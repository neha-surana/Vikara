
package business.survey;

public class Survey {

    private long survey_id;
    private String gender;
    private String country;
    private String state;
    private boolean self_employed;
    private boolean family_history;
    private String no_employees;
    private boolean remote_work;
    private boolean tech_company;
    private String care_options;
    private String wellness_program;
    private String seek_help;
    private String leave_difficulty;
    private String mental_health_consequence;
    private String physical_health_consequence;
    private String coworker;
    private String supervisor;
    private String mental_vs_physical;
    private String age_range;


    public Survey(long surveyId, String gender, String country, String state, boolean self_employed, boolean family_history, String no_employees, boolean remote_work, boolean tech_company, String care_options, String wellness_program, String seek_help, String leave_difficulty, String mental_health_consequence, String physical_health_consequence, String coworker, String supervisor, String mental_vs_physical, String age_range) {
        this.survey_id = surveyId;
        this.gender = gender;
        this.country = country;
        this.state = state;
        this.self_employed = self_employed;
        this.family_history = family_history;
        this.no_employees = no_employees;
        this.remote_work = remote_work;
        this.tech_company = tech_company;
        this.care_options = care_options;
        this.wellness_program = wellness_program;
        this.seek_help = seek_help;
        this.leave_difficulty = leave_difficulty;
        this.mental_health_consequence = mental_health_consequence;
        this.physical_health_consequence = physical_health_consequence;
        this.coworker = coworker;
        this.supervisor = supervisor;
        this.mental_vs_physical = mental_vs_physical;
        this.age_range = age_range;
    }

    public long getSurveyId() {
        return survey_id;
    }

    public void setSurveyId(long surveyId) {
        this.survey_id = surveyId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public boolean getIsSelf_employed() {
        return self_employed;
    }

    public void setIsSelf_employed(boolean self_employed) {
        this.self_employed = self_employed;
    }

    public boolean getIsFamily_history() {
        return family_history;
    }

    public void setIsFamily_history(boolean family_history) {
        this.family_history = family_history;
    }

    public String getNo_employees() {
        return no_employees;
    }

    public void setNo_employees(String no_employees) {
        this.no_employees = no_employees;
    }

    public boolean getIsRemote_work() {
        return remote_work;
    }

    public void setIsRemote_work(boolean remote_work) {
        this.remote_work = remote_work;
    }

    public boolean getIsTech_company() {
        return tech_company;
    }

    public void setIsTech_company(boolean tech_company) {
        this.tech_company = tech_company;
    }

    public String getCare_options() {
        return care_options;
    }

    public void setCare_options(String care_options) {
        this.care_options = care_options;
    }

    public String getWellness_program() {
        return wellness_program;
    }

    public void setWellness_program(String wellness_program) {
        this.wellness_program = wellness_program;
    }

    public String getSeek_help() {
        return seek_help;
    }

    public void setSeek_help(String seek_help) {
        this.seek_help = seek_help;
    }

    public String getLeave() {
        return leave_difficulty;
    }

    public void setLeave(String leave_difficulty) {
        this.leave_difficulty = leave_difficulty;
    }

    public String getMental_health_consequence() {
        return mental_health_consequence;
    }

    public void setMental_health_consequence(String mental_health_consequence) {
        this.mental_health_consequence = mental_health_consequence;
    }

    public String getPhysical_health_consequence() {
        return physical_health_consequence;
    }

    public void setPhysical_health_consequence(String physical_health_consequence) {
        this.physical_health_consequence = physical_health_consequence;
    }

    public String getCoworker() {
        return coworker;
    }

    public void setCoworker(String coworker) {
        this.coworker = coworker;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getMental_vs_physical() {
        return mental_vs_physical;
    }

    public void setMental_vs_physical(String mental_vs_physical) {
        this.mental_vs_physical = mental_vs_physical;
    }

    public String getAge_range() {
        return age_range;
    }

    public void setAge_range(String age_range) {
        this.age_range = age_range;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "surveyId=" + survey_id +
                ", gender='" + gender + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", self_employed=" + self_employed +
                ", family_history=" + family_history +
                ", no_employees='" + no_employees + '\'' +
                ", remote_work=" + remote_work +
                ", tech_company=" + tech_company +
                ", care_options='" + care_options + '\'' +
                ", wellness_program='" + wellness_program + '\'' +
                ", seek_help='" + seek_help + '\'' +
                ", leave_difficulty='" + leave_difficulty + '\'' +
                ", mental_health_consequence='" + mental_health_consequence + '\'' +
                ", physical_health_consequence='" + physical_health_consequence + '\'' +
                ", coworker='" + coworker + '\'' +
                ", supervisor='" + supervisor + '\'' +
                ", mental_vs_physical='" + mental_vs_physical + '\'' +
                ", age_range='" + age_range + '\'' +
                '}';
    }


}
