package ca.aequilibrium.castle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button mBtnRun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnRun = (Button) findViewById(R.id.btn_run);

        //boundary test
        int[] t1 = new int[] {2};
        int[] t2 = new int[] {1, 2};
        int[] t3 = new int[] {2, 3};
        int[] t4 = new int[] {6, 1, 4};

        //ending with same height
        //Ps: 8, 7
        //Vs: 2, 4, 3, 3
        int[] t5 = new int[] {2, 6, 6, 8, 7, 7, 4, 7, 3, 3};

        //Ps: 6, 8, 7, 7, 7
        //Vs: 2, 2, 4, 3, 3
        int[] t6 = new int[] {2, 2, 6, 4, 8, 7, 3, 4, 7, 3, 7, 7};

        //starting with same height
        //Ps: 6, 6, 7, 7, 7
        //Vs: 4, 4, 3
        int[] t7 = new int[] {6, 6, 4, 6, 7, 7, 4, 7, 3};

        //Ps: 6, 8, 10
        //Vs: 1, 1, 3, 6, 3
        int[] t8 = new int[] {1, 1, 6, 3, 8, 7, 6, 10, 7, 3};

        //normal cases
        //Ps: 6, 9, 9, 10
        //Vs: 2, 3, 7, 4
        int[] t9 = new int[] {2, 6, 3, 9, 7, 9, 4, 10};

        //Ps: 8, 9, 11, 10
        //Vs: 2, 1, 7, 4
        int[] t10 = new int[] {2, 6, 8, 4, 1, 9, 7, 11, 4, 10};

        //Ps: 99, 92, 74, 95, 39, 95, 71, 86, 74, 75, 63, 99, 94 (totals: 13)
        //Vs: 18, 35, 0, 33, 32, 5, 24, 8, 24, 33, 29, 58 (totals: 12)
        int[] t11 = new int[] {99, 18, 92, 35, 74, 0, 95, 71, 39, 33, 39, 32, 37, 45, 57, 71, 95, 5, 71, 24, 86, 8, 51, 54, 74, 24, 75, 70, 33, 63, 29, 99, 58, 94};

        //Ps: 85, 80, 96, 67, 87, 83, 64, 90, 99, 25, 51, 97, 76 (totals: 13)
        //Vs: 38, 65, 22, 22, 51, 24, 60, 52, 23, 11, 24, 13, 19, 12, 12 (totals: 15)
        int[] t12 = new int[] {85, 72, 72, 38, 80, 69, 65, 68, 96, 22, 22, 49, 67, 51, 61, 63, 87, 66, 24, 80, 83, 71, 60, 64, 52, 90, 60, 49, 31, 23, 99, 94, 11, 25, 24, 51, 15, 13, 39, 67, 97, 19, 76, 12, 12};

        final List<int[]> hs = new ArrayList<>();
        hs.add(t1);
        hs.add(t2);
        hs.add(t3);
        hs.add(t4);
        hs.add(t5);
        hs.add(t6);
        hs.add(t7);
        hs.add(t8);
        hs.add(t9);
        hs.add(t10);
        hs.add(t11);
        hs.add(t12);

        mBtnRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = "";
                for (int i = 0; i < hs.size(); i++) {
                    txt = "";
                    for (int j = 0; j < hs.get(i).length; j++) {
                        txt += hs.get(i)[j];
                        if (j < hs.get(i).length - 1) {
                            txt += ", ";
                        }
                    }
                    Log.d("Castles", txt);
                    int num = Castles.countCastles(hs.get(i));
                    Log.d("Castles", "Number of castles:" + num);
                    Log.d("Castles", "-------------------------");
                }
            }
        });
    }
}
