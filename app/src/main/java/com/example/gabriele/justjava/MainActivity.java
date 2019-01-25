package com.example.gabriele.justjava;

         import android.os.Bundle;
         import android.support.v7.app.AppCompatActivity;
         import android.util.Log;
         import android.view.View;
         import android.widget.CheckBox;
         import android.widget.TextView;

         import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity=0;
    boolean isWhippedChecked=false;
    boolean isChocolateChecked=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void whippedCreamCheck(View view) {

        CheckBox whippedCheckBox = (CheckBox) findViewById(R.id.whipped_cream_check_box);
        /*if(whippedCheckBox.isChecked())
            isChecked=true;*/
        isWhippedChecked=whippedCheckBox.isChecked();

    }

    public void chocolateCheckBox(View view) {

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_check_box);
        /*if(whippedCheckBox.isChecked())
            isChecked=true;*/
        isChocolateChecked=chocolateCheckBox.isChecked();

    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        //display(quantity);

        createOrderSummary();

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    /**
     * This method displays the given price on the screen.
     */

    /*private int displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }*/

    public void increment(View view) {
        //TextView quantity_text_view = (TextView) findViewById(R.id.quantity_text_view);
        //int quantity=0;
        quantity++;
        display(quantity);
    }

    public void decrement(View view){
        TextView quantity_text_view = (TextView) findViewById(R.id.quantity_text_view);
        //int quantity=0;
        quantity--;
        display(quantity);
    }

    public void createOrderSummary(){


        TextView order_summary_text_view = (TextView) findViewById(R.id.order_summary_text_view);

        if(order_summary_text_view.getText().toString()=="")
            order_summary_text_view.setText("ORDER SUMMARY\n");


        TextView name_editText_view = (TextView) findViewById(R.id.name_edit_text);
        String name=name_editText_view.getText().toString();


        TextView summary_text_view = (TextView) findViewById(R.id.summary_text_view);
        summary_text_view.setText
                (
                        "Name "+name+"\n"+
                                "Add whipped cream? "+isWhippedChecked+
                                "\n"+"Add chocolate? "+isChocolateChecked+"\n"
                                +
                        "Quantity: "+quantity+"\n"+
                        "Total: € "+quantity*5+"\n"+
                        "Thank you!"
                );



    }

}
