var openModal = function () {
    $("#novaAtividadeModal").modal("show");
};

var clearModal = function () {
    $("#formulario_nova_atividade").find("textarea").val("");
    $("#formulario_nova_atividade").find("input").not("input[type=submit]").val("");
};

var showModalEditMode = function (activity) {
    $("#formulario_nova_atividade").prop("method", "put");
    prepareModal(activity);
    openModal();
};

var showModalNewMode = function () {
    $("#formulario_nova_atividade").prop("method", "post");
    clearModal();
};

var prepareModal = function (activity) {
    var date = activity.startHour.date;
    $("#nova-atividade-data").val(date.day + "/" + date.month + "/" + date.year);
    $("#nova-atividade-horainicio").val(activity.startHour.time.hour + ":" + activity.startHour.time.minute);
    $("#nova-atividade-horafim").val(activity.finishHour.time.hour + ":" + activity.finishHour.time.minute);
    $("#nova-atividade-projeto").val(activity.project.id);
    $("#nova-atividade-subprojeto").val(activity.subProject.id);
    $("#nova-atividade-grupo").val(activity.group.id);
    $("#nova-atividade-tipo").val(activity.activityType.id);
    $("#nova-atividade-descricao").val(activity.description);
    $("#nova-atividade-id").val(activity.id);
};

$(document).ready(function () {
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
            url: "lancamentohoras/",
            data: $(this).serialize(),
            type: $(this).attr("method"),
            success: function (html) {
                clearModal();
            }
        });
    });
});