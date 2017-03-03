package com.kurta.example.admin.kruta.Utils;


import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.example.admin.kurta.R;


public class CustomProgressDialog extends Dialog
{
	public static CustomProgressDialog dialog;
	public static boolean isMyDialogShowing;

	public static CustomProgressDialog show(Context context, CharSequence title,CharSequence message) 
	{
		return show(context, title, message, false);
	}

	public static CustomProgressDialog show(Context context, CharSequence title,CharSequence message, boolean indeterminate) 
	{
		return show(context, title, message, indeterminate, false, null);
	}

	public static CustomProgressDialog show(Context context, CharSequence title,CharSequence message, boolean indeterminate, boolean cancelable) 
	{
		return show(context, title, message, indeterminate, cancelable, null);
	}

	public static void Dismiss()
	{
		if(dialog != null && dialog.isShowing())
		{
			isMyDialogShowing = false;
			dialog.dismiss();
		}
	}
	@SuppressLint("NewApi")
	public static void show(Context context)
	{
		dialog = new CustomProgressDialog(context);
		dialog.setCancelable(false);
		/* The next line will add the ProgressBar to the dialog. */
		dialog.addContentView(new ProgressBar(context), new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();  
		lp.dimAmount=0.5f;  //0.0f
		dialog.getWindow().setAttributes(lp);

		if(dialog != null && !dialog.isShowing())
		{
			Log.i("Showing","Showing Dialog");
			isMyDialogShowing = true;
			dialog.show();
			dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
		}
	}

	@SuppressLint("NewApi")
	public static CustomProgressDialog show(Context context, CharSequence title,CharSequence message, boolean indeterminate,boolean cancelable, OnCancelListener cancelListener) 
	{
		dialog = new CustomProgressDialog(context);
		dialog.setTitle(title);
		dialog.setCancelable(cancelable);
		dialog.setOnCancelListener(cancelListener);
		/* The next line will add the ProgressBar to the dialog. */
		dialog.addContentView(new ProgressBar(context), new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		dialog.show();

		return dialog;
	}

	public CustomProgressDialog(Context context) 
	{
		super(context, R.style.NewDialog);
	}
}