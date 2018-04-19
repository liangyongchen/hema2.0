package com.hema.assist.common.utils;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by asus on 2017/8/12.
 */

public class EditTextUilt {
/**
 * OnKeyListener
 * EditText 使用 OnKeyListener 监听
 * 一、XML布局中：如果 EditText 属性存在： imeActionId、imeActionLabel、imeOptions    android:ime 开头的属性，不能设置 android:singleLine="true" 属性
 * 1.android:imeActionId="@+id/login"
 * 2.android:imeActionLabel="@string/action_sign_in_short"
 * 3.android:imeOptions="actionDone"
 * （作用：回车不换行，比设置 singleLine = true 好）
 * 二、XML布局中：XML布局中：如果 EditText 属性存在：android:singleLine="true" ，不能设置有 android:ime 开头的属性
 * （ 作用：回车不换行，比设置 android:ime 的属性差 ）
 *
 * OnEditorActionListener
 * EditText 使用 OnEditorActionListener 监听 可以同时使用 ime属性和 android:singleLine="true" 属性
 */

    /**
     * 设置 EditText 的编辑状态 true false
     *
     * @param et     控件
     * @param isEdit true : 可以编辑 ； false : 不可编辑
     */
    public static void setEditTextEdit(EditText et, boolean isEdit) {

        et.setEnabled(isEdit); // 焦点
        et.setClickable(isEdit);  // 点击
        // 编辑
        et.setFocusable(isEdit);
        et.setFocusableInTouchMode(isEdit);
        et.requestFocus();
        et.requestFocusFromTouch();

    }


    /**
     * 指定隐藏 Edittext 键盘(全选)
     */
    public static void requestFocusTokenHideAll(Activity ac, EditText v) {

        InputMethodManager imm = (InputMethodManager) ac.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        v.postInvalidate(); // 刷新界面
        v.requestFocus();   // 获取光标
        v.setSelectAllOnFocus(true);  // 获取焦点
        v.setSelection(0, v.getText().toString().length());  // 全选

    }


    /**
     * 指定隐藏 Edittext 键盘(不选)
     */
    public static void requestFocusTokenHide(Activity ac, EditText v) {

        InputMethodManager imm = (InputMethodManager) ac.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        v.postInvalidate(); // 刷新界面
        v.requestFocus();   // 获取光标
        v.setSelectAllOnFocus(true);  // 获取焦点

    }


    /**
     * 指定弹出 Edittext 键盘
     */
    public static void TokenShow(Activity ac, EditText v) {
        v.setFocusable(true);
        v.setFocusableInTouchMode(true);
        v.requestFocus();
        InputMethodManager imm = (InputMethodManager) ac.getSystemService(Context.INPUT_METHOD_SERVICE);
        // imm.showSoftInputFromInputMethod(v.getWindowToken(), 0);
        imm.showSoftInput(v, InputMethodManager.SHOW_FORCED);
        // imm.showSoftInput(v, 0);
    }

    /**
     * 指定弹出 Edittext 键盘
     */
    public static void TokenShow(EditText v) {
        v.setFocusable(true);
        v.setFocusableInTouchMode(true);
        v.requestFocus();
        //调用系统输入法
        InputMethodManager inputManager = (InputMethodManager) v
                .getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.showSoftInput(v, 0);
    }

    /**
     * 设置 EditText 只能输入点书店后两文小数点
     *
     * @param v
     */
    public static void addTextChangedListener(EditText v) {
        try {
            v.addTextChangedListener(new TextWatcher() {

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (s.toString().contains(".")) {
                        if (s.length() - 1 - s.toString().indexOf(".") > 2) {
                            s = s.toString().subSequence(
                                    0,
                                    s.toString().indexOf(".") + 3
                            );
                            v.setText(s);
                            v.setSelection(s.length());
                        }
                    }
                    if (s.toString().trim().substring(0).equals(".")) {
                        s = "0" + s;
                        v.setText(s);
                        v.setSelection(2);
                    }

                    if (s.toString().startsWith("0")
                            && s.toString().trim().length() > 1) {
                        if (!s.toString().substring(1, 2).equals(".")) {
                            v.setText(s.subSequence(0, 1));
                            v.setSelection(1);
                            return;
                        }
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {


                }
            });

        } catch (Exception e) {

        }
    }

}
