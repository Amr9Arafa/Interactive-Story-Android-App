package model;

public class Page {

	private int mImageID;
	private String mText;
	private Choice mChoice1;
	private Choice mChoice2;
	private Boolean mIsFinal=false;
	
	public Boolean getmIsFinal() {
		return mIsFinal;
	}
	
	public void setmIsFinal(Boolean mIsFinal) {
		this.mIsFinal = mIsFinal;
	}
	public Page(int imageID,String text, Choice choice1,Choice choice2)
	{
		mImageID= imageID;
		mText= text;
		mChoice1=choice1;
		mChoice2=choice2;
	}
	public Page(int imageID,String text)
	{
		mImageID= imageID;
		mText= text;
		mChoice1= null;
		mChoice2=null;
		mIsFinal=true;
	}
	

	public int getImageId() {
		return mImageID;
	}

	public void setImageId(int id) {
		this.mImageID = id;

	}

	public String getText() {
		return mText;
	}

	public void setText(String mText) {
		this.mText = mText;
	}

	public Choice getChoice1() {
		return mChoice1;
	}

	public void setChoice1(Choice mChoice1) {
		this.mChoice1 = mChoice1;
	}

	public Choice getChoice2() {
		return mChoice2;
	}

	public void setChoice2(Choice mChoice2) {
		this.mChoice2 = mChoice2;
	}

}
