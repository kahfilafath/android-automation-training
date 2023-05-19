package com.android.automation.training.hooks;

import com.android.automation.training.drivers.AndroidDriverInit;
import io.cucumber.java.Before;

public class AndroidDriverHook {

  AndroidDriverInit init = new AndroidDriverInit();
  @Before
  public void init(){
    init.initialize();
  }

}
