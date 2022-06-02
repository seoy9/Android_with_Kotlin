package dalc.hsy.lotto

import java.text.SimpleDateFormat
import java.util.*

object LottoNumberMaker {
    //랜덤으로 추출하여 6개의 로또 번호를 만드는 함수
    fun getRandomLottoNumbers(): MutableList<Int> {
        //무작위로 생성된 로또 번호를 저장할 가변 리스트 생성
        val lottoNumbers = mutableListOf<Int>()

        //6번 반복하는 for문
        for(i in 1..6) {
            //랜덤한 번호를 임시 저장할 변수 생성
            var number = 0

            do {
                //랜덤한 번호를 추출해 number 변수에 저장
                number = getRandomLottoNumber()

                //lottoNumbers에 number 변수의 값이 없을 때까지 반복
            } while(lottoNumbers.contains(number))

            //이미 뽑은 리스트에 없는 번호가 나올 때까지 반복했으므로 중복이 없는 상태
            //추출된 번호를 뽑은 리스트에 추가
            lottoNumbers.add(number)
        }
        return lottoNumbers
    }

    //랜덤으로 1 ~ 45 번호 중 하나의 번호를 생성하는 함수
    fun getRandomLottoNumber(): Int {
        //Random.nextInt는 0 ~ 전달받은 파라미터 값 미만의 번호를 생성
        //ex) Random).nextInt(10)은 0 ~ 9 까지의 무작위 수를 반환
        //1 ~ 45 까지의 번호를 생성하려면 파라미터에 45를 넣고 결과값에 1을 더함
        return Random().nextInt(45) + 1
    }

    //Shuffle을 사용해 로또 번호 생성
    fun getShuffleLottoNumbers(): MutableList<Int> {
        //1 ~ 45번의 로또 번호를 저장할 리스트 생성
        val list = mutableListOf<Int>()

        //1 ~ 45까지 for문을 돌면서 리스트에 로또 번호 저장
        for(number in 1..45) {
            list.add(number)
        }

        //리스트를 무작위로 섞음
        list.shuffle()

        //리스트를 앞에서부터 순서대로 6개를 짤라 결과 반환
        return list.subList(0, 6)
    }

    //입력받은 이름에 대한 해시코드를 사용하여 로또 번호를 섞고 결과를 반환
    fun getLottoNumbersFromHash(name: String): MutableList<Int> {
        //1 ~ 45번의 로또 번호를 저장할 리스트 생성
        val list = mutableListOf<Int>()

        //1 ~ 45까지 for문을 돌면서 리스트에 로또 번호 저장
        for(number in 1..45) {
            list.add(number)
        }

        //SimpleDataFormat은 날짜의 시간값을 포맷화된 텍스트 형태로 바꿔주는 클래스
        //현재 Date의 "yyyy-MM-dd" 문자열과 이름 문자열을 합침
        val targetString = SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(Date()) + name

        //리스트를 무작위로 섞음, 섞는 기준으로 Random(SEED) 사용
        //SEED값은 전달받은 이름의 해시코드를 사용
        list.shuffle(Random(targetString.hashCode().toLong()))

        //리스트를 앞에서부터 순서대로 6개를 짤라 결과 반환
        return list.subList(0, 6)
    }
}