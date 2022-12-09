package business.survey;

import business.JdbcUtils;
import business.VikarastoreDbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SurveyDaoJdbc implements SurveyDao {

    private static final String FIND_ALL_SQL =
            "SELECT category_id, name " +
                    "FROM category";

    private static final String FIND_BY_SURVEY_ID_SQL =
            "SELECT category_id, name " +
                    "FROM category " +
                    "WHERE category_id = ?";

    private static final String CREATE_SURVEY_SQL =
            "insert into survey ( gender, country, state, self_employed, family_history, no_employees, remote_work,"+
    "tech_company, care_options, wellness_program, seek_help, leave_difficulty, mental_health_consequence,"+
    "physical_health_consequence,coworker,supervisor,mental_vs_physical,age_range)"+
    "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

    @Override
    public List<Survey> findAll() {
        List<Survey> categories = new ArrayList<>();
        try (Connection connection = JdbcUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_SQL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Survey category = readSurvey(resultSet);
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new VikarastoreDbException("Encountered a problem finding all categories", e);
        }
        return categories;
    }

    @Override
    public Survey findBySurveyId(long surveyid) {
        Survey survey = null;
        try (Connection connection = JdbcUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_SURVEY_ID_SQL)) {
            statement.setLong(1, surveyid);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    survey = readSurvey(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new VikarastoreDbException("Encountered a problem finding category " + surveyid, e);
        }
        return survey;
    }

    @Override
    public void createSurvey(Survey survey) {
        try(Connection connection = JdbcUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(CREATE_SURVEY_SQL)
        ){
            System.out.println("Inside Create");
            statement.setString(1,survey.getGender());
            statement.setString(2,survey.getCountry());
            statement.setString(3,survey.getState());
            statement.setBoolean(4,survey.getIsSelf_employed());
            statement.setBoolean(5,survey.getIsFamily_history());
            statement.setString(6,survey.getNo_employees());
            statement.setBoolean(7,survey.getIsRemote_work());
            statement.setBoolean(8, survey.getIsTech_company());
            statement.setString(9,survey.getCare_options());
            statement.setString(10,survey.getWellness_program());
            statement.setString(11,survey.getSeek_help());
            statement.setString(12,survey.getLeave());
            statement.setString(13,survey.getMental_health_consequence());
            statement.setString(14,survey.getPhysical_health_consequence());
            statement.setString(15,survey.getCoworker());
            statement.setString(16,survey.getSupervisor());
            statement.setString(17,survey.getMental_vs_physical());
            statement.setString(18,survey.getAge_range());
            System.out.println(statement.toString());

            statement.execute();
            System.out.println("Inside Create 3");

        }
        catch (SQLException e) {
            System.out.println(e);
            throw new VikarastoreDbException("Encountered a problem adding a survey ");
        }
    }

    private Survey readSurvey(ResultSet resultSet) throws SQLException {
        long survey_id = resultSet.getLong("survey_id");
        String gender = resultSet.getString("gender");
        String country = resultSet.getString("country");
        String state = resultSet.getString("state");
        boolean self_employed = resultSet.getBoolean("self_employed");
        boolean family_history = resultSet.getBoolean("family_history");
        String no_employees = resultSet.getString("no_employees");
        boolean remote_work = resultSet.getBoolean("remote_work");
        boolean tech_company = resultSet.getBoolean("tech_company");
        String care_options=resultSet.getString("care_options");
        String wellness_program=resultSet.getString("wellness_program");
        String seek_help=resultSet.getString("seek_help");
        String leave_difficulty=resultSet.getString("leave_difficulty");
        String mental_health_consequence=resultSet.getString("mental_health_consequence");
        String physical_health_consequence=resultSet.getString("physical_health_consequence");
        String coworker=resultSet.getString("coworker");
        String supervisor=resultSet.getString("supervisor");
        String mental_vs_physical=resultSet.getString("mental_vs_physical");
        String age_range=resultSet.getString("age_range");
        return new Survey(survey_id, gender,country, state, self_employed, family_history, no_employees, remote_work,
                tech_company, care_options, wellness_program, seek_help, leave_difficulty, mental_health_consequence,
                physical_health_consequence,coworker,supervisor,mental_vs_physical,age_range);
    }

}
