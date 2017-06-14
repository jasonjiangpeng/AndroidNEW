package com.jh.rental.user.utils.jason;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.jh.rental.user.other.apputilss.utilcode.utils.Utils;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2016/8/2
 *     desc  : 键盘相关工具类
 * </pre>
 */
public class KeyboardCtrol {
  private  static KeyboardCtrol  keyboardCtrol;
  private  InputMethodManager  methodManager;
    private KeyboardCtrol(){
        methodManager= (InputMethodManager) BaseContext.context.getSystemService(Context.INPUT_METHOD_SERVICE);
    }
   public static KeyboardCtrol  getkeyboardUtils(){
          if (keyboardCtrol==null){
              return new KeyboardCtrol();
          }
          return keyboardCtrol;
   }
   public   KeyboardCtrol showInput(View text){
     //  methodManager.
       methodManager.showSoftInput(text,0);
       return keyboardCtrol;
  }


}