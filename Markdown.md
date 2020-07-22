># MarkDown 문법 정리 (작성중)

>## 헤더 표현
* # `#` -> `<h1>` 태그와 같습니다.
* ## `##` -> `<h2>` 태그와 같습니다.
* ### `###` -> `<h3>` 태그와 같습니다.

>## 인라인코드 표현
* `<a>Input Text -> ` <a>Input Text.

>## Italics
* `_Input Text_` -> _Input Text_.

>## Bold
* `**Input Text**` -> **Input Text**.

>## URL Link
* 단순 URL 입력시 링크로 된다.
    * https://github.com/sksggg123/sksggg123/
* 주소를 숨기고 싶을때는 `[문구정의 ~ ](URL주소 ~ )` 문법을 쓴다.
    * [sksggg123 정리 링크](https://github.com/sksggg123/sksggg123/)

>## 이미지
* 이미지를 추가를 하고싶을때는 `![문구정의 ~ ](Image Url ~)` 으로 입력하면 아래와 같이 된다. (출처:google main page logo)
    *   ![google](https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_120x44dp.png)


>## 소스코드 표현
*  ` ```java [중략] ``` `  중략 안에 소스코드 입력하면 아래처럼 표현 가능.

```java
    public class Utils{
        public static List<String> getList(final String code)
        {
            List<String> returnList = new ArrayList<>();
            if(code.isEmpty()){
                returnList.add("null");
                return returnList
            }else
            {
                returnList.add(code);
                return returnList
            }
        }
    }
```