package programmers;

public class 붕대감기 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int life = health;
		int skill = 0; //붕대감기 지속시간
		int attackIndex = 0;
		for(int sec = 1; sec <= attacks[attacks.length-1][0]; sec++){
            if(sec == attacks[attackIndex][0]){
                skill = 0;
                life -= attacks[attackIndex][1];
                attackIndex++;
                if(life<=0) return -1;
                
            } else {
				life += bandage[1];
				skill++;
				if(skill == bandage[0]) {
					life += bandage[2];
					skill = 0;
				}
				if(life > health) life = health;
			}
		}

		return life;
    }
}    
    public int solution(int[] bandage, int health, int[][] attacks) {
		int answer = 0;
		
		
		//t초 붕대감기 / 초당 회복력 x / t초간 붕대감기 성공 시 추가 회복력 y
		int t = bandage[0], x = bandage[1], y = bandage[2];
		
		//최대 체력 health
		//attacks 몬스터가 공격한 시간 , 피해량
		
		//attack[0].length 공격 횟수
		int attackCount = attacks.length-1;
		int skill = 0; //붕대감기 지속시간
		
		for(int sec = 1; sec <= attacks[attackCount][0]; sec++){
		
			boolean isAttacked = false;
			boolean dead = false;
			
			for(int i = 0; i<=attackCount; i++){
			    if(sec == attacks[i][0]){
			        health -= attacks[i][1]; //공격 데미지 들어감
			        skill = 0;
			        isAttacked = true;
			        
			        if(health <= 0){ //체력 닳아서 죽은 경우
			            dead = true;
                        health = -1;
			            answer = -1;
			        }
			        if(sec == attacks[attackCount][0]){ //마지막 공격을 한 시간일 때
			            answer = health;
			            
			        }
			        break;
			    } 
			}

			if(dead){
			    //체력 다 한 경우 종료
            
			    break;
			    
			}else if(isAttacked){
			    //공격 당하면 다음 초로 넘어가기

			    continue;
			        
			}else{
			    //공격 안 당한 경우
			    skill++;
			    health += x;
			    
			    if(skill == t){
			        //연속 붕대감기 성공한 경우
			        health += y;
			        skill = 0;
			    }
			    if(health>=30) {
			    	health = 30;
			    }

			}
		}

		return answer;
    }
}
