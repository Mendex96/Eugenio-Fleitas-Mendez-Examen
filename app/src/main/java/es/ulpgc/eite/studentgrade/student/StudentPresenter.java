package es.ulpgc.eite.studentgrade.student;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.studentgrade.app.AppMediator;
import es.ulpgc.eite.studentgrade.app.GradeToStudentState;
import es.ulpgc.eite.studentgrade.app.StudentToGradeState;

/**
 * Created by Luis on marzo, 2022
 */
public class StudentPresenter implements StudentContract.Presenter {

  public static String TAG = "StudentGrade.StudentPresenter";

  private WeakReference<StudentContract.View> view;
  private StudentState state;
  private StudentContract.Model model;
  private AppMediator mediator;

  public StudentPresenter(AppMediator mediator) {
    this.mediator = mediator;
    state = mediator.getStudentState();
  }

  @Override
  public void onStart() {
    Log.e(TAG, "onStart()");
    state.data1 = model.getData1();
    state.data2 = model.getData2();
    state.data3 = model.getData3();
    state.data = " ";
    view.get().onDataUpdated(state);



  }

  @Override
  public void onRestart() {
    Log.e(TAG, "onRestart()");
    model.onRestartScreen(state.data);
    view.get().onDataUpdated(state);

  }

  @Override
  public void onResume() {
    Log.e(TAG, "onResume()");

    // use passed state if is necessary
    GradeToStudentState savedState = getStateFromNextScreen();
    if (savedState != null) {

      model.onDataFromNextScreen(savedState.data);
      state.data = model.getStoredData();

    }


  }

  @Override
  public void onBackPressed() {
    // Log.e(TAG, "onBackPressed()");


  }

  @Override
  public void onPause() {
    Log.e(TAG, "onPause()");


  }

  @Override
  public void onDestroy() {
    // Log.e(TAG, "onDestroy()");

  }

  @Override
  public void onOutstandingGradeBtnClicked() {

    state.data = "9,10";
    StudentToGradeState studentToGradeState = new StudentToGradeState();
    studentToGradeState.data = state.data;
    passStateToNextScreen(studentToGradeState);
    view.get().navigateToNextScreen();


  }

  @Override
  public void onMentionGradeBtnClicked() {

    state.data = "7,8";
    StudentToGradeState studentToGradeState = new StudentToGradeState();
    studentToGradeState.data = state.data;
    passStateToNextScreen(studentToGradeState);
    view.get().navigateToNextScreen();

  }

  @Override
  public void onPassGradeBtnClicked() {

    state.data = "5,6";
    StudentToGradeState studentToGradeState = new StudentToGradeState();
    studentToGradeState.data = state.data;
    passStateToNextScreen(studentToGradeState);
    view.get().navigateToNextScreen();

  }

  private GradeToStudentState getStateFromNextScreen() {
    return mediator.getNextStudentScreenState();
  }

  private void passStateToNextScreen(StudentToGradeState state) {
    mediator.setNextStudentScreenState(state);
  }


  @Override
  public void injectView(WeakReference<StudentContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(StudentContract.Model model) {
    this.model = model;
  }

}
