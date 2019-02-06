package com.example.gabriele.justjava;

         import android.content.Intent;
         import android.net.Uri;
         import android.os.Bundle;
         import android.support.v7.app.AppCompatActivity;
         import android.util.Log;
         import android.view.View;
         import android.widget.CheckBox;
         import android.widget.TextView;
         import android.widget.Toast;

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

        display (quantity);

    }


    public void whippedCreamCheck(View view) {

        CheckBox whippedCheckBox = (CheckBox) findViewById(R.id.whipped_cream_check_box);
        /*if(whippedCheckBox.isChecked())
            isChecked=true;*/
        isWhippedChecked=whippedCheckBox.isChecked();



    }

    public void chocolateCheck(View view) {

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_check_box);
        /*if(whippedCheckBox.isChecked())
            isChecked=true;*/
        isChocolateChecked=chocolateCheckBox.isChecked();

    }

    public int calculatePrice(boolean isWhippedChecked,boolean isChocolateChecked){
        int baseprice=5;

        if(isWhippedChecked)
            baseprice+=1;

        if(isChocolateChecked)
            baseprice+=2;

        return quantity*baseprice;

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
        if (quantity < 100)
            quantity++;

        else{// Show an error message as a toast
            Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
            }

        display (quantity);
        return;
    }

    public void decrement(View view){
        TextView quantity_text_view = (TextView) findViewById(R.id.quantity_text_view);
        //int quantity=0;

        if (quantity>0)
            quantity--;

        else{// Show an error message as a toast
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            }

        display (quantity);
        return;
    }


    public String nameCheck(){
        TextView name_editText_view = (TextView) findViewById(R.id.name_edit_text);
        String name=name_editText_view.getText().toString();

        if (name.equals(""))
            name="-";

        return name;
    }



    /**
     * This method is called when the order button is clicked.
     */

    public void sendEmail(View view, String message){

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); //only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for"+nameCheck());
        intent.putExtra(Intent.EXTRA_TEXT,message);
        if (intent.resolveActivity(getPackageManager())!= null){
            startActivity(intent);}
    }

    public void createOrderSummary(View view){


        TextView order_summary_text_view = (TextView) findViewById(R.id.order_summary_text_view);

//        if(order_summary_text_view.getText().toString()=="")
//            order_summary_text_view.setText("ORDER SUMMARY\n");





//        TextView summary_text_view = (TextView) findViewById(R.id.summary_text_view);
//        summary_text_view.setText
//                (
//                        "Name "+nameCheck()+"\n"+
//                                "Add whipped cream? "+isWhippedChecked+
//                                "\n"+"Add chocolate? "+isChocolateChecked+"\n"
//                                +
//                        "Quantity: "+quantity+"\n"+
//                        "Total: € "+calculatePrice(isWhippedChecked,isChocolateChecked)+"\n"+
//                        "Thank you!"
//                );

        String message= (
                        "Name "+nameCheck()+"\n"+
                                "Add whipped cream? "+isWhippedChecked+
                                "\n"+"Add chocolate? "+isChocolateChecked+"\n"
                                +
                        "Quantity: "+quantity+"\n"+
                        "Total: € "+calculatePrice(isWhippedChecked,isChocolateChecked)+"\n"+
                        "Thank you!"
                );

        sendEmail(view, message);


    }


//
}
