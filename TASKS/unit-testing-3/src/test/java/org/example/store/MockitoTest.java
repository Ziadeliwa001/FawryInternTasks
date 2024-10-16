package org.example.store;

import org.junit.jupiter.api.Test;
//import org.mockito.Matchers;
import static org.mockito.Mockito.*;

import java.util.List;

public class MockitoTest {

    @Test
    public void test() {
        List list = mock(List.class);

        when(list.get(anyInt())).then(answer -> {
           int index = answer.getArgument(0, Integer.class);
           return "COLOR #" + index;
        });

        list.add("red");
        list.add("green");
        list.add("blue");

        System.out.println(list);

        System.out.println(list.get(0));
        System.out.println(list.get(100));

//        Mockito.verify(list).add("blue");
//        Mockito.verify(list).add("red");

        verify(list, times(3)).add(any());


    }

}
