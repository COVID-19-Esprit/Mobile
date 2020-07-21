package com.mycompany.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Component;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;

public class QuizResultGUI {
    private Form gui;
    private boolean isCovid;

    QuizResultGUI(Form parent,boolean isCovid){
        gui = new Form("Result", BoxLayout.y());
        this.isCovid = isCovid;
        gui.getToolbar().addCommandToLeftBar("back",null,(ev)->{
            parent.showBack();
        });

        if (isCovid) ifIsCovid();
        else ifIsNotCovid();

    }

    private void ifIsNotCovid() {
        SpanLabel title = new SpanLabel("Your state of health does not require any health intervention");
        SpanLabel text1 = new SpanLabel("Stay at home and limit your contact with others");
        SpanLabel text2 = new SpanLabel("Respect the hygienic measures");

        title.setTextBlockAlign(10);

        gui.addComponent(title);
        gui.addComponent(text1);
        gui.addComponent(text2);
    }
    private void ifIsCovid() {
        SpanLabel title = new SpanLabel("Your symptoms require prompt management");
        SpanLabel text1 = new SpanLabel("Isolate yourself and wear a surgical mask");
        SpanLabel text2 = new SpanLabel("Do not travel to consult a private or public health facility");
        SpanLabel text3 = new SpanLabel("Call 190 immediately");
        SpanLabel text4 = new SpanLabel("To fight against your fever avoid taking Anti-inflammatories and take paracetamol");



        gui.addComponent(title);
        gui.addComponent(text1);
        gui.addComponent(text2);
        gui.addComponent(text3);
        gui.addComponent(text4);
    }


    public Form geTGui() {
        return gui;
    }
}
