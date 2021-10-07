package querys;

import DAO.CursoDAO;
import model.Curso;

import java.util.List;

public class querysExecution {
    public static void main(String[] args){
        CursoDAO cursoDAO = new CursoDAO();

        //CREATE
        Curso cursoParaInsercao = new Curso(
            "MySQL",
             98
        );
        cursoDAO.create(cursoParaInsercao);

        //READ (Consulta)
        cursoDAO = new CursoDAO();
        List<Curso> cursos = cursoDAO.list();

        cursos.stream().forEach(System.out::println);


        //Consulta com filtro

            /*
           Curso cursoParaConsulta = cursoDAO.getById(2);
           System.out.println(cursoParaConsulta);
            */

        //Atualizar
                /*
               Curso cursoParaAtualizar = cursoDAO.getById(3);
                cursoParaAtualizar.setNomeCurso("HTML");
                cursoParaAtualizar.setDuracaoHoras(20);

                cursoDAO.update(cursoParaAtualizar);

                cursoDAO.list().forEach(System.out::println);

                */



        //Delete
            /*
            cursoDAO.delete(2);
            cursoDAO.list().forEach(System.out::println);
            */

    }
}
