package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;
import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class AssertJTest {

    @Test
    @DisplayName("isEqualTo는 객체참조 주소값을 비교함(동일성)으로 일치하지 않는다.")
    void equalTest() {
        //given
        Dog fido = new Dog("fido", 4.52F);
        Dog fidosClone = new Dog("fido", 4.52F);
        //when
        //then
//        assertThat(fido).isEqualTo(fidosClone);
        assertThat(fido).isNotEqualTo(fidosClone);
    }

    @Test
    void trueAndFalseTest() {
        assertThat("".isEmpty()).isTrue();
        assertThat("test".isEmpty()).isFalse();
    }

    @Test
    void listTest() {
        List<String> list = Arrays.asList("1", "2", "3");
        assertThat(list).contains("1");
        assertThat(list).isNotEmpty();
        assertThat(list).startsWith("1");

        assertThat(list)
                .isNotEmpty()
                .contains("1")
                .startsWith("1")
                .doesNotContainNull()
                .containsSequence("2", "3"); // 2, 3 값을 포함하는지 테스트
    }

    @Test
    void stringTest() {
        assertThat('c')
                .isNotEqualTo('a')
                .inUnicode()
                .isGreaterThanOrEqualTo('b') // b값보다 actual값이 크거나 같은 경우
                .isLessThanOrEqualTo('d')
                .isLowerCase();
    }

    @Test
    void clazzTest() {
        assertThat(Runnable.class).isInterface();
        assertThat(Exception.class).isAssignableFrom(NoSuchElementException.class); // 상속받았는지 검증
    }

    @Test
    void fileTest() {
        String resourceName = "test.txt";

        ClassLoader classLoader = getClass().getClassLoader();

        File file = new File(Objects.requireNonNull(classLoader.getResource(resourceName)).getFile());
//        String absolutePath = file.getAbsolutePath();

        assertThat(file)
                .exists()
                .isFile()
                .canRead()
                .canWrite();
    }

    @Test
    void numberTest() {
        assertThat(5.1).isEqualTo(5, withPrecision(1d)); // withPrecision를 사용하여 실수를 정확하게 검증할 수 있다.
        assertThat(5.1).isEqualTo(5, withPrecision(0.1));
    }

    @Test
    void inputStreamTest() {
        InputStream actualStream = getClass().getClassLoader().getResourceAsStream("test.txt");
        InputStream expectStream = getClass().getClassLoader().getResourceAsStream("compare.txt");
        assertThat(actualStream).hasSameContentAs(expectStream); // 파일 내용이 동일한지 검증
    }

    @Test
    void mapTest() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(3, "c");
        map.put(4, "d");

        assertThat(map)
                .containsKey(1)
                .isNotEmpty()
                .doesNotContainKey(6)
                .contains(entry(2, "b"));
    }

    @Test
    @DisplayName("예외 발생 시 좀더 명확하게 에러메시지를 전달하고 싶은 경우 사용할 듯")
    void messageTest() {
        Dog fido = new Dog("fido", 4.52F);
        assertThat(fido.getName())
                .as("%s's age should be equal to 100", fido.getName())
                .isEqualTo(100);
    }

}

class Dog {
    private String name;
    private Float weight;

    public Dog(String name, Float weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }
}
