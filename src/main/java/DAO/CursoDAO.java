package DAO;

import connection.ConnectionFactory;
import model.Curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    //CREATE
    public void create(Curso curso){
        //Fazer conexão com o banco
        try(Connection conn = ConnectionFactory.getConnection()){

            //Preparar consulta SQL
            String sql = "INSERT INTO curso(nomeCurso, duracaoHoras) VALUES(?, ?)";

            //Preparar o statment com os parametros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getNomeCurso());
            stmt.setInt(2, curso.getDuracaoHoras());

            //Executa a inserção e armazena o número de linhas afetadas
            int rowsAffected = stmt.executeUpdate();

            System.out.println("Inserção efetuada "+rowsAffected+" linhas foram afetadas");

        }catch (SQLException e){
            System.out.println("Inserção falhou");
            e.printStackTrace();
        }
    }


    //READ (Consulta)
    public List<Curso> list(){
        //Preparar lista que irá retornar os cursos após consultar o banco de dados
        List<Curso> cursos = new ArrayList<>();

        //Fazer a conexão com o banco
        try(Connection conn = ConnectionFactory.getConnection()){

            //Preparar Consulta SQL
            String sql = "SELECT * FROM curso";

            //Preparar o statment com os parametros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            //Criar um objeto curso e guardar na lista de cursos
            while(rs.next()){
                int id = rs.getInt("id");
                String nomeCurso = rs.getString("nomeCurso");
                int duracaoHoras = rs.getInt("duracaoHoras");

                cursos.add(new Curso(
                    id,
                    nomeCurso,
                    duracaoHoras
                ));
            }
        }catch (SQLException e){
            System.out.println("Listagem de alunos falhou");
            e.printStackTrace();
        }

        return cursos;
    }

    //READ (Consulta) com filtro
    public Curso getById(int id){
        Curso curso = new Curso();

        //Fazer a conexão com o banco
        try(Connection conn = ConnectionFactory.getConnection()){
            //Preparar Consulta SQL
            String sql = "SELECT * from curso WHERE id = ?";

            //Preparar o statment com os parametros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            //Executa consulta e armazena o retorno da consulta no objeto "rs"
            ResultSet rs = stmt.executeQuery();

            //Guardar os valores retornados da tabela aluno no objeto aluno
            if (rs.next()){
                curso.setId(rs.getInt("id"));
                curso.setNomeCurso(rs.getString("nomeCurso"));
                curso.setDuracaoHoras(rs.getInt("duracaoHoras"));
            }
        }catch (SQLException e){
            System.out.println("Listagem de cursos falhou");
            e.printStackTrace();
        }
        return curso;
    }


    //UPDATE Atualizar
    public void update(Curso curso){
        try(Connection conn = ConnectionFactory.getConnection()){
            //Preparar Consulta SQL
            String sql = "UPDATE curso SET nomeCurso = ?, duracaoHoras = ? WHERE id = ?";

            //Preparar o statment com os parametros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, curso.getNomeCurso());
            stmt.setInt(2, curso.getDuracaoHoras());
            stmt.setInt(3, curso.getId());


            //Executa a inserção e armazena o número de linhas afetadas
            int rowsAffected = stmt.executeUpdate();

            System.out.println("Atualização efetuada com sucesso, "+ rowsAffected+" linhas foram afetadas");
        }catch(SQLException e){
            System.out.println("Atualização falhou");
            e.printStackTrace();
        }
    }

    //DELETE
    public void delete(int id){
        try(Connection conn = ConnectionFactory.getConnection()){
            //Preparar Consulta SQL
            String sql = "DELETE FROM curso WHERE id = ?";

            //Preparar o statment com os parametros recebidos
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            //Executa a inserção e armazena o número de linhas afetadas
            int rowsAffected = stmt.executeUpdate();

            System.out.println("Deleted efetuada, "+ rowsAffected+" foram afetadas");
        }catch (Exception e){
            System.out.println("Delete falhou");
            e.printStackTrace();
        }
    }
}
