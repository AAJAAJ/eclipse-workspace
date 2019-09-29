package cn.yunhe.bean;

public class Hero implements Comparable{

	private String skill;
	private int speed;
	
	public Hero() {}
	
	public Hero(String skill,int speed) {
		this.skill = skill;
		this.speed = speed;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Hero [skill=" + skill + ", speed=" + speed + "]";
	}

	@Override
	public int compareTo(Object o) {
		Hero hero = (Hero)o;
		return this.speed-hero.speed;
	}
	
}
