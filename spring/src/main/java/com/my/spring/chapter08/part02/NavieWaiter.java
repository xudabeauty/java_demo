package com.my.spring.chapter08.part02;

import com.my.spring.chapter08.part03.SeondNeedTest;

public class NavieWaiter  implements Waiter{
    @SeondNeedTest
      public void greetTo(String clientName) {
        System.out.println("NavieWaiter:greet to :"+clientName+"...");
    }
    @SeondNeedTest
    public void serveTo(String clientName) {
        System.out.println("NavieWaiter: server to:"+clientName+"...");
    }

}
