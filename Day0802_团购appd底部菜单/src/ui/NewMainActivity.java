package ui;

import com.yanminghui.day0802.R;
import com.yanminghui.day0802.R.id;
import com.yanminghui.day0802.R.layout;

import frag.DealFragment;
import frag.MoreFragment;
import frag.MyFragment;
import frag.NearbyFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class NewMainActivity extends FragmentActivity implements OnPageChangeListener{
	private RadioGroup rg;
	private ViewPager vpcontainer;
	private InnerFragmentPagerAdapter adapter;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		rg=(RadioGroup)findViewById(R.id.rg);
		vpcontainer=(ViewPager) findViewById(R.id.vp_container);
		
		
		//∏¯vpcontainer…Ë÷√  ≈‰∆˜
		adapter=new InnerFragmentPagerAdapter(getSupportFragmentManager());
		vpcontainer.setAdapter(adapter);
		
		vpcontainer.setOnPageChangeListener(this);
		
		InnerOnCheckChangeListener listener=new InnerOnCheckChangeListener();	
		rg.setOnCheckedChangeListener(listener);
	}
	private class InnerFragmentPagerAdapter extends FragmentPagerAdapter{

		public InnerFragmentPagerAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int position) {
			Fragment fragment=null;
			switch (position) {
			case 0:
				fragment=new DealFragment();
				break;
			case 1:
				fragment=new NearbyFragment();
				break;
			case 2:
				fragment=new MyFragment();
				break;
			case 3:
				fragment=new MoreFragment();
				break;

			}
			return fragment;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 4;
		}
		

	}
	private class InnerOnCheckChangeListener implements OnCheckedChangeListener{
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {

			switch(checkedId){
			case R.id.rb_deal:
				vpcontainer.setCurrentItem(0);
				break;
			case R.id.rb_nearby:
				vpcontainer.setCurrentItem(1);
				break;
			case R.id.rb_my:
				vpcontainer.setCurrentItem(2);
				break;
			case R.id.rb_more:
				vpcontainer.setCurrentItem(3);
				break;
			}

		}	
	}

	@Override
	public void onPageScrolled(int position, float positionOffset,
			int positionOffsetPixels) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int position) {
		switch (position) {
		case 0:
			rg.check(R.id.rb_deal);
			break;
		case 1:
			rg.check(R.id.rb_nearby);
			break;
		case 2:
			rg.check(R.id.rb_my);
			break;
		case 3:
			rg.check(R.id.rb_more);
			break;

		}

	}

	@Override
	public void onPageScrollStateChanged(int state) {
		// TODO Auto-generated method stub

	}



}
