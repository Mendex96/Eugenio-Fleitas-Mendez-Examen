package es.ulpgc.eite.studentgrade.student;

import java.lang.ref.WeakReference;

/**
 * Created by Luis on marzo, 2022
 */
public interface StudentContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void onDataUpdated(StudentViewModel viewModel);

    void navigateToNextScreen();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void onResume();

    void onStart();

    void onRestart();

    void onBackPressed();

    void onPause();

    void onDestroy();

    void onOutstandingGradeBtnClicked();

    void onMentionGradeBtnClicked();

    void onPassGradeBtnClicked();
  }

  interface Model {
    String getStoredData();

    String getData1();
    String getData2();
    String getData3();

    void onDataFromNextScreen(String data);

    void onRestartScreen(String data);
  }

}
