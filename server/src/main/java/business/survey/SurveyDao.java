package business.survey;

import java.util.List;

public interface SurveyDao {

    public List<Survey> findAll();

    public Survey findBySurveyId(long categoryId);

    public Survey findBySurveyName(String categoryName);
}
