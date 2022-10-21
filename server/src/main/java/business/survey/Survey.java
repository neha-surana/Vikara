
package business.survey;

public class Survey {

    private long surveyId;
    private String name;

    public Survey(long surveyId, String name) {
        this.surveyId = surveyId;
        this.name = name;
    }

    public long getSurveyId() {
        return surveyId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + surveyId +
                ", name='" + name + '\'' +
                '}';
    }
}
