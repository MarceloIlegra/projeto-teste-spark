package com.ilegra.jt.lancamentodehoras.service;

import com.ilegra.jt.lancamentodehoras.dao.SubProjectDAO;
import com.ilegra.jt.lancamentodehoras.pojo.SubProject;
import java.util.NoSuchElementException;
import java.util.Optional;

public class SubProjectService {
    
    public static Optional<SubProject> getById(Integer id) {
        Optional<SubProject> subProjectDAO = new SubProjectDAO().getById(id);
        return isSubProjectPresent(subProjectDAO);
    }

    private static Optional<SubProject> isSubProjectPresent(Optional<SubProject> subProjectDAO) throws NoSuchElementException {
        if(subProjectDAO.isPresent()){
            return subProjectDAO;
        }else{
            throw new NoSuchElementException("Sub Projeto Não encontrado");
        }
    }
    
}
