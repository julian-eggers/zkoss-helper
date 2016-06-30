package com.itelg.zkoss.helper.messagebox;

import static org.zkoss.zul.Messagebox.QUESTION;
import static org.zkoss.zul.Messagebox.show;
import static org.zkoss.zul.Messagebox.Button.NO;
import static org.zkoss.zul.Messagebox.Button.YES;

import org.zkoss.zul.Messagebox.Button;

public class MessageboxHelper
{
    public static void ask(String question, Runnable onYes, Runnable onNo)
    {
        show(question, null, new Button[] { YES, NO }, QUESTION, clickEvent ->
        {
            if (YES.equals(clickEvent.getButton()))
            {
                onYes.run();
            }
            else if (onNo != null)
            {
                onNo.run();
            }
        });
    }

    public static void ask(String question, Runnable onYes)
    {
        ask(question, onYes, null);
    }
}