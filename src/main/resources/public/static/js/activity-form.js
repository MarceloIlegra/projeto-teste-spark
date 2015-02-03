var openModal = function () {
    $("#novaAtividadeModal").modal("show");
};

var closeModal = function () {
    $("#novaAtividadeModal").modal("hide");
};

var clearModal = function () {
    $("#formulario_nova_atividade").find("textarea").val("");
    $("#formulario_nova_atividade").find("input").not("input[type=submit]").val("");
    $("select").val("");
};

var showModalEditMode = function (activity) {
    $("#formulario_nova_atividade").prop("method", "put");
    $("#formulario_nova_atividade").prop("action", "/atividades/" + activity.id);
    prepareModal(activity);
    openModal();
};

var showModalNewMode = function () {
    $("#formulario_nova_atividade").prop("method", "post");
    $("#formulario_nova_atividade").prop("action", "/atividades");
    clearModal();
    $("#nova-atividade-data").datepicker("setDate", new Date());
};

var prepareModal = function (activity) {
    var date = activity.startHour.date;
    console.log(formatHour(activity.startHour.time.hour, activity.startHour.time.minute));
    if(date.day <10)date.day = "0"+ date.day;
    if(date.month<10)date.month = "0"+date.month;
    $("#nova-atividade-data").val(date.day + "/" + date.month + "/" + date.year);
    $("#nova-atividade-horainicio").val(formatHour(activity.startHour.time.hour, activity.startHour.time.minute));
    $("#nova-atividade-horafim").val(formatHour(activity.finishHour.time.hour, activity.finishHour.time.minute));
    $("#nova-atividade-projeto").val(activity.project.id);
    $("#nova-atividade-subprojeto").val(activity.subProject.id);
    $("#nova-atividade-grupo").val(activity.group.id);
    $("#nova-atividade-tipo").val(activity.activityType.id);
    $("#nova-atividade-descricao").val(activity.description);
    $("#nova-atividade-id").val(activity.id);
};

var loadTable = function () {
    $.ajax({
        url: "/atividades/_listagem",
        type: "get",
        success: function (html) {
            $("#section-atividades").html(html);
            loadEvents();
        }
    });
};

var loadEvents = function () {
    $(".editar_atividade").click(function (event) {
        event.preventDefault();
        $.getJSON($(this).attr("href"), function (data) {
            showModalEditMode(data);
        });
    });
    
    $("#abrirModalAtividade").click(function (event) {
        event.preventDefault();
        showModalNewMode();
    });

    $("#formulario_nova_atividade").submit(function (event) {
        event.preventDefault();
        $.ajax({
            url: $(this).attr("action"),
            data: $(this).serialize(),
            type: $(this).attr("method"),
            success: function (message) {
                closeModal();                
                loadTable();
            }
        });
    });
};

$(document).ready(function () {
    loadEvents();
});