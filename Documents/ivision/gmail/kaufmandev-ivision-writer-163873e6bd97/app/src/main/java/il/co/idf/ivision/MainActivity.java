package il.co.idf.ivision;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.speech.RecognizerIntent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final int REQ_CODE_SPEECH_INPUT = 100;
    private TextView textView;
    private int lineNumber = 1;
    private int wordNumber = 0;
    private boolean firstRight = true;
    private boolean firstLeft = true;
    private ArrayList<ArrayList> textArray;
    private boolean startNewLine;
    private String david = "svetagimpelson@gmail.com";
    private String benjamin = "eyar.st@gmail.com ";
    private boolean checked = false;
    private boolean isEmail = false;
    private boolean emailMode = false;
    private boolean confirm = false;
    private boolean contactMode = false;
    private boolean subjectMode = false;
    private boolean editMode =false;
    private boolean insertMode = false;
    private String contact = null;
    private String subject = null;
    private String content = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendEmail("test","hello");
        TTS.init(MainActivity.this);
        setupViews();
        textArray = new ArrayList<ArrayList>();
    }

    private ArrayList parseText(String text) {
        return new ArrayList(Arrays.asList(text.split(" ")));
    }

    private String parseList() {
        String text = null;
        for (int i = 0; i < textArray.size(); i++) {
            text = parseLine(i, text);
        }
        return text;
    }

    private String parseLine(int lineNumber, String text) {
        List line = textArray.get(lineNumber);
        String lineString = null;
        for (int j = 0; j < line.size(); j++) {
            String word = String.valueOf(line.get(j));

            if(lineString == null) {
                lineString = word;
            } else {
                if(word.equals("email")){
                    isEmail = true;
                }
                lineString += word;
            }

            if(j == line.size()-1) {
                lineString += "\n";
            } else {
                lineString += " ";
            }
        }

        if(text == null) {
            text = lineString;
        } else {
            text += lineString;
        }
        return text;
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setupViews() {
        textView = findViewById(R.id.textView);
        ConstraintLayout layout = findViewById(R.id.constraintLayout);
        final Context context = MainActivity.this;
        final MediaPlayer mp = MediaPlayer.create(context, R.raw.end_sound);
        layout.setOnTouchListener(new OnSwipeTouchListener(context) {

            public void onDoubleTapClick(){
//                if (wordNumber == 0) {
//                    TTS.speak("Do You Want Delete " + getWord(lineNumber, wordNumber) + "?");
//                } else {
//                    TTS.speak("Do You Want Delete " + getWord(lineNumber, wordNumber-1) + "?");
//                }
                editMode = true;
                TTS.speak("Edit mode, Delete or insert?");
            }

            public void onSwipeTop() {
                firstRight = true;
                firstLeft = true;
                if (linesNumber() >= lineNumber - 1 && lineNumber - 1 != 0) {
                    lineNumber -= 1;
                    wordNumber = 0;
                    TTS.speak(getWord(lineNumber, wordNumber));
                } else {
                    mp.start();
                }
            }

            public void onSwipeBottom() {
                firstRight = true;
                firstLeft = true;
                if (linesNumber() >= lineNumber + 1) {
                    lineNumber += 1;
                    wordNumber = 0;
                    TTS.speak(getWord(lineNumber, wordNumber));
                } else {
                    mp.start();
                }
            }

            public void onSwipeRight() {
                if (wordsNumber() >= wordNumber + 1) {
                    if(firstRight){
                        TTS.speak(parseLine(lineNumber - 1, null));
                        firstRight = false;
                    } else {
                        TTS.speak(getWord(lineNumber, wordNumber));
                        wordNumber += 1;
                    }
                } else {
                    startNewLine = true;
                    mp.start();
                }
            }

            public void onSwipeLeft() {
                if(wordNumber == 0 && firstLeft) {
                    int lineSize = getLine(lineNumber).size();
                    wordNumber = lineSize-1;
                    TTS.speak(getWord(lineNumber, wordNumber));
                    firstLeft = false;
                    firstRight = false;
                } else if (wordsNumber() > wordNumber - 1 && wordNumber - 1 >= 0) {
                    wordNumber -= 1;
                    TTS.speak(getWord(lineNumber, wordNumber));
                } else {
                    mp.start();
                }
            }
        });

        setupButton();
    }

    private void setupButton() {
        Button sptButton = findViewById(R.id.sptButton);
        sptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
                try {
                    startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
                } catch (ActivityNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private int wordsNumber() {
        return textArray.get(lineNumber-1).size();
    }

    private int linesNumber() {
        return textArray.size();
    }

    private String getWord(int lineNumber, int wordNumber) {
        return String.valueOf(getLine(lineNumber).get(wordNumber));
    }

    private ArrayList getLine(int lineNumber) {
        return textArray.get(lineNumber-1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String resultString = result.get(0);
                    if (startNewLine && !editMode) {
                        //end of the line
                        textArray.add(parseText(resultString));
//
                        textView.setText(parseList());
                    } else {
                        if(emailMode){
                            ArrayList currLine = new ArrayList(parseText(resultString));
                            if (editMode){
                                if(currLine.get(0).equals("delete")){
                                    TTS.speak("Deleting " + getWord(lineNumber, wordNumber-1));
                                    textArray.get(lineNumber-1).remove(--wordNumber);
                                    textView.setText(parseList());
                                    editMode = false;
                                }
                                else if(currLine.get(0).equals("insert")){
                                    TTS.speak("please record");
                                    editMode = false;
                                    insertMode = true;
                                }
                                else{
                                    TTS.speak("please repeat");
                                }
                            }
                            else if(insertMode){
                                handle(resultString);
                                insertMode = false;
//                                lineNumber = textArray.size()-1;
//                                wordNumber = 0;
                            }
                            else{
                                checked = true;
                                for (int i = 0; i < currLine.size(); i++) {
                                    if (currLine.get(i).equals("send")) {
                                        checked = false;
                                        TTS.speak("sending");
//                                    sendEmail("my title","my massage");
                                        break;
//                                    send
                                    }
                                }
                                if(checked){
                                    if (wordNumber == 0) {
                                        if (textArray.size() != 0 && getLine(lineNumber).size() != 0) {
                                            //start the app next recording after start
                                            handleStartNewLine(resultString);
                                        } else {
                                            //when i start the app first line
                                            textArray.add(parseText(resultString));
                                            textView.setText(parseList());
                                        }
                                        checked = false;
                                    } else {
                                        //center of word
                                        handle(resultString);
                                        checked = false;
                                    }
                                }
                            }
                        }
                        else if(subjectMode){
                            if(!confirm) {
                                subject = new String(resultString);
                                TTS.speak("The subject is: " + subject + ". Do you confirm?");
                                confirm = true;
                            }
                            else{
                                if(resultString.equals("yes")){
                                    subjectMode = false;
                                    confirm = false;
                                    emailMode = true;
                                    TTS.speak("What is the content?");
                                }else {
                                    confirm = false;
                                }
                            }

                        }
                        else {
                            if (contactMode) {
                                contact = new String(resultString);
                                if(contact.equals("David")){
                                    TTS.speak(david + ". What is the subject?");
                                    contactMode = false;
                                    subjectMode = true;
                                }
                                else if (contact.equals("Benjamin")){
                                    TTS.speak(benjamin+ ". What is the subject?");
                                    contactMode = false;
                                    subjectMode = true;
                            }
                                else{
                                    TTS.speak( "contact was not found");
                                }
                            }
                            else {
                                ArrayList currLine = new ArrayList(parseText(resultString));
                                for (int i = 0; i < currLine.size(); i++) {
                                    if (currLine.get(i).equals("email")) {
                                        TTS.speak("Ready to send email. Who Should I send the email?");
                                        contactMode = true;
                                    }
                                }
                            }
                        }

                    }
                }
                break;
            }

        }
    }


    private void handleStartNewLine(String resultString) {
        ArrayList newWords = parseText(resultString);
        ArrayList<String> line = new ArrayList<String>();
        line.addAll(newWords);
        ArrayList<ArrayList> until = new ArrayList<ArrayList>();
        ArrayList<ArrayList> after = new ArrayList<ArrayList>();
        int i;
        for (i = 0; i < lineNumber; i++) {
            until.add(textArray.get(i));
        }

        if(i < linesNumber()){
            for (i += 1; i > lineNumber; i++) {
                after.add(textArray.get(i));
            }
        }

        ArrayList<ArrayList> newTextArray = new ArrayList<ArrayList>();
        newTextArray.addAll(until);
        newTextArray.add(line);
        newTextArray.addAll(after);
        textArray = newTextArray;
        lineNumber = until.size() + 1;
        textView.setText(parseList());
    }

    private void handle(String resultString) {
        ArrayList line = getLine(lineNumber);
        int lineSizeBefore = line.size();
        ArrayList newWords = parseText(resultString);
        ArrayList<String> until = new ArrayList<String>();
        ArrayList<String> after = new ArrayList<String>();


        if(insertMode) {
            int i;
            for (i = 0; i < wordNumber; i++) {
                until.add(String.valueOf(line.get(i)));
            }


            if (wordNumber == 0) {
                for (int j = 0; j < lineSizeBefore; j++) {
                    after.add(String.valueOf(line.get(j)));
                }
            } else {
                for (int j = lineSizeBefore; j > i; j--) {
                    after.add(String.valueOf(line.get(j - 1)));
                }
                for (int x = 0; x < after.size() / 2; x++) {
                    String temp = after.get(x);
                    after.set(x, after.get(after.size() - x - 1));
                    after.set(after.size() - x - 1, temp);
                }
            }


            ArrayList newLine = new ArrayList<>();
            newLine.addAll(until);
            newLine.addAll(newWords);
            newLine.addAll(after);
            textArray.set(lineNumber-1, newLine);
        }
        else{
            textArray.set(textArray.size()-1,newWords);
        }

        textView.setText(parseList());
    }



    private void sendEmail(String title, String message) {
        GMailSender sender = new GMailSender(
                "ivision.dev.poc@gmail.com",
                "eyarsveta");
        try {
            sender.sendMail(title, message,
                    "ivision.dev.poc@gmail.com",
                    "svetagimpelson@gmail.com");
        } catch (Exception e) {
            Log.d("email error", e.toString());
//            e.printStackTrace();
        }

    }
}
