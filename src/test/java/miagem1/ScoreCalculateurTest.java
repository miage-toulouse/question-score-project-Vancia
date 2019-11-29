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
        int nbIndices = 5;
        question = new QuestionAChoixMultiple("énoncé", listRep, nbIndices);
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
        assertEquals(0f, score,  0.01f);

        // when: l'étudiant donne deux bonnes réponses 2 et 3
        ArrayList listEtu1 = new ArrayList<Integer>();
        listEtu1.add(2);
        listEtu1.add(3);
        // and: on demande le score de l'étudiant sur une question
        float score1 = calculateur.calculeScore(listEtu1, question);
        // then: le score est de 2*100/3
        assertEquals(2*100/3f, score1, 0.01f);

        // when: l'étudiant donne toutes les bonnes réponses 2, 3 et 5
        ArrayList listEtu2 = new ArrayList<Integer>();
        listEtu2.add(2);
        listEtu2.add(3);
        listEtu2.add(5);
        // and: on demande le score de l'étudiant sur une question
        float score2 = calculateur.calculeScore(listEtu2, question);
        // then: le score est de 100
        assertEquals(100f, score2,0.01f);

        // when: l'étudiant donne toutes les réponses 1, 2, 3, 4 et 5
        ArrayList listEtu3 = new ArrayList<Integer>();
        listEtu3.add(1);
        listEtu3.add(2);
        listEtu3.add(3);
        listEtu3.add(4);
        listEtu3.add(5);
        // and: on demande le score de l'étudiant sur une question
        float score3 = calculateur.calculeScore(listEtu3, question);
        // then: le score est de 0
        assertEquals(0f, score3, 0.01f);

        // when: l'étudiant donne une mauvaise réponse et deux bonnes
        // réponses 1 2, et 3
        ArrayList listEtu4 = new ArrayList<Integer>();
        listEtu4.add(1);
        listEtu4.add(2);
        listEtu4.add(3);
        // and: on demande le score de l'étudiant sur une question
        float score4 = calculateur.calculeScore(listEtu4, question);
        // then: le score est de 0
        assertEquals(16.66f, score4, 0.01f);
    }
}