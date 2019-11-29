package miagem1;

import java.util.List;

/**
 * Classe répresentant une question à choix multiple
 */
public class QuestionAChoixMultiple implements QuestionAChoix {

    private String enonce;
    private List<Integer> indicesBonnesReponses;
    private int nbIndices;

    /**
     * Une question à choix multiple est complètement caractérisé par son énoncé, la liste des indices qui forment
     * la bonne réponse et la liste des mauvaises réponses
     * @param enonce l'énoncé de la question
     * @param indicesBonnesReponses la liste des indices formant la bonne réponse.
     * @param nbIndices le nombre d'indices pour la question.
     */
    public QuestionAChoixMultiple(String enonce, List<Integer> indicesBonnesReponses, int nbIndices) {
        this.enonce = enonce;
        this.indicesBonnesReponses = indicesBonnesReponses;
        this.nbIndices = nbIndices;
    }

    /**
     * Récupère l'énoncé de la question
     * @return l'énoncé de la question
     */
    public String getEnonce() {
        return enonce;
    }

    /**
     * Opération permettant de récupérer le score donné par un choix.
     * @param indiceChoix l'indice du choix
     * @return 100/n si indiceChoix appartient à la liste des indices formant la bonne réponse, 0 sinon
     */
    public float getScoreForIndice(int indiceChoix) {
        if (indicesBonnesReponses.contains(indiceChoix)) {
            return 100f/((float)(indicesBonnesReponses.size()));
        } else {
            return -100f/((float) (nbIndices - indicesBonnesReponses.size()));
        }
    }
}
