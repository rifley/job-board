public class Job {
  private String mDescription;
  private String mTitle;
  private String mEmail;

  public Job(String description, String title, String email){
    mDescription = description;
    mTitle = title;
    mEmail = email;
  }

  public String getDescription() {
    return mDescription;
  }

  public String getTitle() {
    return mTitle;
  }

  public String getEmail() {
    return mEmail;
  }
}
