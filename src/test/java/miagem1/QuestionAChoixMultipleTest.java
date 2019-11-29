package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class QuestionAChoixMultipleTest {

    private QuestionAChoixMultiple question;

    @Before
    public void setUp() throws Exception {
        // given : une instance de question à choix multiple
        ArrayList listRep = new ArrayList<Integer>();
        listRep.add(1);
        listRep.add(3);
        int nbIndices = 3;
        question = new QuestionAChoixMultiple("énoncé", listRep, nbIndices);
    }

    @Test
    public void testGetEnonce() {
        // when: on demande l'énoncé de la question
        String enonce = question.getEnonce();
        // then: l'énoncé retourné est l'énoncé fourni à la construction de l'énoncé
        assertEquals("énoncé", enonce);
    }

    @Test
    public void getScoreForIndice() {
        // when: quand l'étudiant donne l'indice d'une bonne réponse
        int indice = 1;
        // and: on demande le score de l'étudiant
        float score = question.getScoreForIndice(indice);
        // then: le score obtenu est de 50
        assertEquals(50f, score,0.01f);

        // when: quand l'étudiant donne l'indice d'une mauvaise réponse
        int indiceM = 2;
        // and: on demande le score de l'étudiant
        float scoreM = question.getScoreForIndice(indiceM);
        // then: le score obtenu est de 0
        assertEquals(0f, scoreM, 0.01f);
    }
}