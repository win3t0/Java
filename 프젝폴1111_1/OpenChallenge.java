package chapter7;
import java.util.*;

/**
 * Word 클래스는 영어 단어와 그 뜻을 표현합니다.
 */
class Word {
    private String word;      // 영어 단어
    private String meaning;   // 단어의 한국어 뜻
    
    /**
     * Word 클래스의 생성자입니다.
     * 
     * @param word    영어 단어
     * @param meaning 단어의 한국어 뜻
     */
    public Word(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }
    
    /**
     * 영어 단어를 반환합니다.
     * 
     * @return 영어 단어
     */
    public String getWord() {
        return word;
    }
    
    /**
     * 단어의 한국어 뜻을 반환합니다.
     * 
     * @return 단어의 뜻
     */
    public String getMeaning() {
        return meaning;
    }
    
    /**
     * Word 객체의 문자열 표현을 반환합니다.
     * 
     * @return 단어와 그 뜻을 포함한 문자열
     */
    @Override
    public String toString() {
        return word + " - " + meaning;
    }
}

/**
 * WordQuiz 클래스는 영어 단어 뜻 맞추기 퀴즈 게임을 관리합니다.
 */
public class OpenChallenge {
    private Vector<Word> words;  // 단어들을 저장하는 벡터
    
    /**
     * WordQuiz 클래스의 생성자입니다. 미리 정의된 단어들을 벡터에 추가합니다.
     */
    public OpenChallenge() {
        words = new Vector<Word>();
        // 단어 추가
        words.add(new Word("love", "사랑"));
        words.add(new Word("animal", "동물"));
        words.add(new Word("friend", "친구"));
        words.add(new Word("computer", "컴퓨터"));
        words.add(new Word("book", "책"));
        words.add(new Word("music", "음악"));
        words.add(new Word("city", "도시"));
        words.add(new Word("flower", "꽃"));
        words.add(new Word("sun", "태양"));
        words.add(new Word("moon", "달"));
        words.add(new Word("water", "물"));
        words.add(new Word("fire", "불"));
        words.add(new Word("earth", "지구"));
        words.add(new Word("wind", "바람"));
        words.add(new Word("sky", "하늘"));
        words.add(new Word("tree", "나무"));
        words.add(new Word("mountain", "산"));
    }
    
    /**
     * 퀴즈를 실행하는 메소드입니다.
     */
    public void runQuiz() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\"명품영어\"의 단어 테스트를 시작합니다. -1을 입력하면 종료합니다.");
        System.out.println("현재 17개의 단어가 들어 있습니다.");
        while(true) {
	        // 정답 단어를 랜덤하게 선택
	        Word correctAnswer = words.get(random.nextInt(words.size()));
	        
	        // 선택지를 저장할 세트 생성 (중복 방지)
	        Set<Word> choices = new HashSet<>();
	        choices.add(correctAnswer);
	        
	        // 정답이 아닌 단어를 랜덤하게 추가하여 총 4개의 선택지 생성
	        while (choices.size() < 4) {
	            Word incorrectWord = words.get(random.nextInt(words.size()));
	            if (!incorrectWord.equals(correctAnswer)) {
	                choices.add(incorrectWord);
	            }
	        }
	        
	        // 선택지를 리스트로 변환하고 섞기
	        List<Word> choiceList = new ArrayList<>(choices);
	        Collections.shuffle(choiceList);
	        
	        // 질문 출력
	        System.out.println(correctAnswer.getWord() + "?");
	        for (int i = 0; i < choiceList.size(); i++) {
	            System.out.print("("+(i + 1) + ")" + choiceList.get(i).getMeaning()+" ");
	        }
	        System.out.print(":>");
	        
	        // 사용자 입력 받기
	        int userAnswer = scanner.nextInt();
	        
	        // 입력이 -1일 경우 게임 끝내기
	        if(userAnswer == -1) {
	        	System.out.println("\"명품영어\"를 종료합니다...");
	        	break;
	        }
	        
	        // 정답 확인
	        if (choiceList.get(userAnswer - 1).getMeaning().equals(correctAnswer.getMeaning())) {
	            System.out.println("Excellent !!");
	        } else {
	            System.out.println("no. !!");
	        }
        }
        scanner.close();
    }
    
    /**
     * 프로그램의 시작점입니다.
     * 
     * @param args 명령줄 인자
     */
    public static void main(String[] args) {
    	OpenChallenge quiz = new OpenChallenge();
        quiz.runQuiz();
    }
}
