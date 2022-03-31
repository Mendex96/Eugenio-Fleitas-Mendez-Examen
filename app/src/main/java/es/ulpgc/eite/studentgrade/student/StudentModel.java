package es.ulpgc.eite.studentgrade.student;

/**
 * Created by Luis on marzo, 2022
 */
public class StudentModel implements StudentContract.Model {

  public static String TAG = "StudentGrade.StudentModel";

  private String data;
  public String data1 = "OUTSTANDING (9-10)";
  public String data2 = "MENTION (7-8)";
  public String data3 = "PASS (5-6)";


  public StudentModel(String data) {
    this.data = data;
  }


  public String getData2() {
    return data2;
  }

  public String getData1() {
    return data1;
  }

  public String getData3() {
    return data3;
  }

  @Override
  public String getStoredData() {
    // Log.e(TAG, "getStoredData()");

    return data;
  }

  @Override
  public void onRestartScreen(String data) {
    // Log.e(TAG, "onRestartScreen()");


    this.data = data;
  }

  @Override
  public void onDataFromNextScreen(String data) {
    // Log.e(TAG, "onDataFromNextScreen()");

    this.data = data;
  }

}