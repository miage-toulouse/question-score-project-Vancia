package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ScoreCalculateurTest {

    private QuestionAChoixMultiple question;
    private ScoreCalculateur calculateur;

    @Before
    public void setUp() throws Exception {
        // given : une instance de question à choix multiple
        ArrayList listRep = new ArrayList<Integer>();
        listRep.add(2);
        listRep.add(3);
        listRep.add(5);
        question = new QuestionAChoixMultiple("énoncé", listRep);
        calculateur = new ScoreCalculateur();
    }

    @Test
    public void testCalculeScore() {
        // when: l'étudiant donne deux mauvaises réponses 1 et 4
        ArrayList listEtu = new ArrayList<Integer>();
        listEtu.add(1);
        listEtu.add(4);
        // and: on demande le score de l'étudiant sur une question
        float score = calculateur.calculeScore(listEtu, question);
        // then: le score est de 0
        assertEquals(score, 0f, 0.01f);

        // when: l'étudiant donne deux bonnes réponses 2 et 3
        ArrayList listEtu1 = new ArrayList<Integer>();
        listEtu1.add(2);
        listEtu1.add(3);
        // and: on demande le score de l'étudiant sur une question
        float score1 = calculateur.calculeScore(listEtu1, question);
        // then: le score est de 2*100/3
        assertEquals(score1, 2*100/3f, 0.01f);

        // when: l'étudiant donne toutes les bonnes réponses 2, 3 et 5
        ArrayList listEtu2 = new ArrayList<Integer>();
        listEtu2.add(2);
        listEtu2.add(3);
        listEtu2.add(5);
        // and: on demande le score de l'étudiant sur une question
        float score2 = calculateur.calculeScore(listEtu2, question);
        // then: le score est de 100
        assertEquals(score2, 100f, 0.01f);
    }
}