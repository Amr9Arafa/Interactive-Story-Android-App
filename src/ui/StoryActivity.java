package ui;

import model.Page;
import model.Story;

import com.example.interactivestory.R;
import com.example.interactivestory.R.layout;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class StoryActivity extends ActionBarActivity {

	private Story mStory=new Story();
    private ImageView mImageView;
    private TextView mTextView ;
    private Button mChoice1;
    private Button mChoice2;
    private String mNAme;
    private Page mCurrentPage;
 
    public static final String TAG =StoryActivity.class.getSimpleName();
    
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_story);

		Intent intent =getIntent();

		mNAme=intent.getStringExtra("name");

		if (mNAme==null)
		{
			mNAme ="Friend";
		}
		Log.d(TAG, mNAme);
		
		mImageView=(ImageView)findViewById(R.id.storyImageView);
		mTextView=(TextView)findViewById(R.id.storyTextView);
		mChoice1=(Button)findViewById(R.id.chiceButton1);
		mChoice2=(Button)findViewById(R.id.choiceButoon2);
		
		loadPAge(0);

	}

	private void loadPAge(int choice){
		
		 mCurrentPage =mStory.getPage(choice);
		String pageText=mCurrentPage.getText();
		pageText=String.format(pageText,mNAme);
		
		Drawable drawable= getResources().getDrawable(mCurrentPage.getImageId()); 
		mImageView.setImageDrawable(drawable);
		mTextView.setText(pageText);
		mTextView.setKeyListener(null);
		
		if(mCurrentPage.getmIsFinal())
		{
			mChoice1.setVisibility(View.INVISIBLE);
			mChoice2.setText("Play again");
			mChoice2.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					finish();
					
				}
			});
		}
		else
		{
			
		
		mChoice1.setText(mCurrentPage.getChoice1().getText());
		mChoice2.setText(mCurrentPage.getChoice2().getText());
		
		mChoice1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				int nextPage= mCurrentPage.getChoice1().getNextPage();
				loadPAge(nextPage);
				
			}
		});
		
	mChoice2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				int nextPage= mCurrentPage.getChoice1().getNextPage();
				loadPAge(nextPage);
				
			}
		});
		
		}
	}

}
