package br.ifpe.web.projeto2.service;

import java.util.List;

import br.ifpe.web.projeto2.Model.*;
import br.ifpe.web.projeto2.exceptions.RespostaCertaException;
import br.ifpe.web.projeto2.exceptions.RespostaErradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.ifpe.web.projeto2.DAO.AlternativaDAO;
import br.ifpe.web.projeto2.DAO.AssuntoDAO;
import br.ifpe.web.projeto2.DAO.DisciplinaDAO;
import br.ifpe.web.projeto2.DAO.QuestoesDAO;
import br.ifpe.web.projeto2.DAO.RespostaDAO;
import br.ifpe.web.projeto2.exceptions.QuestaoExistsException;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuestoesService {

    @Autowired
    private QuestoesDAO questoesDAO;
    @Autowired
    private AlternativaDAO alternativaDAO;
    @Autowired
    private AssuntoDAO assuntoDAO;
    @Autowired
    private DisciplinaDAO disciplinaDAO;
    @Autowired
    private RespostaDAO respostaDao;

    //Método de Criar Questão

    public void criarQuestao(Questoes questoes) throws Exception {

        if (this.findQuestoesByEnunciado(questoes.getEnunciado(), questoes.getTexto()) != null) {
            throw new QuestaoExistsException("Já existe questão com este enunciado: " + questoes.getEnunciado());

        }

        questoesDAO.save(questoes);
    }


    //Método de Criar Assunto

    public void criarAssunto(Assunto assunto) {
        assuntoDAO.save(assunto);
    }

    //Método de Criar Alternativas

    public void criarAlternativa(Alternativa alternativa) {
        alternativaDAO.save(alternativa);
    }

    //Método de criar Disciplina

    public void criarDisciplina(Disciplina disciplina) {
        disciplinaDAO.save(disciplina);
    }

    //Método de salvar resposta
    public void salvarResposta(Resposta resposta) {
        respostaDao.save(resposta);
        //Verificação: se acertar a questão irá aparecer uma mensagem de Resposta Correta
//		if (respostaDao.) {
//			throw new  RespostaCertaException("Resposta Correta");
//
//            //Verificação: se errar a questão irá aparecer uma mensagem de Resposta Incorreta
//		}else {
//		    throw new RespostaErradaException("Resposta Errada");
//
//		}
    }

    //BUSCANDO TODOS OS DISCIPLINAS
    public List<Disciplina> listarDisciplinas() {
        return disciplinaDAO.findAll();
    }

    //Listar questões

    public List<Questoes> listarQuestoes() {
        return questoesDAO.findAll();
    }


    public Questoes findQuestoesByEnunciado(String enunciado, String texto) {
        return questoesDAO.findByEnunciadoTexto(enunciado, texto);
    }

    public Assunto findAssuntoByDescricao(String descricao) {
        return assuntoDAO.findByDescricao(descricao);
    }


}
