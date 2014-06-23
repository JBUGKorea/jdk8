package concurrency;

import java.util.concurrent.RecursiveAction;

public class ForkBlur extends RecursiveAction {

	private static final long serialVersionUID = 1034028690244058505L;

	private int[] mSource;
	private int mStart;
	private int mLength;
	private int[] mDestination;

	// Processing window size; should be odd.
	private int mBlurWidth = 15;

	public ForkBlur(int[] src, int start, int length, int[] dst) {
		mSource = src;
		mStart = start;
		mLength = length;
		mDestination = dst;
	}

	protected void computeDirectly() {
		int sidePixels = (mBlurWidth - 1) / 2;
		for (int index = mStart; index < mStart + mLength; index++) {
			// Calculate average.
			float rt = 0, gt = 0, bt = 0;
			for (int mi = -sidePixels; mi <= sidePixels; mi++) {
				int mindex = Math.min(Math.max(mi + index, 0),
						mSource.length - 1);
				int pixel = mSource[mindex];
				rt += (float)((pixel & 0x00ff0000) >> 16)
						/ mBlurWidth;
				gt += (float)((pixel & 0x0000ff00) >>  8)
						/ mBlurWidth;
				bt += (float)((pixel & 0x000000ff) >>  0)
						/ mBlurWidth;
			}

			// Reassemble destination pixel.
			int dpixel = (0xff000000     ) |
			(((int)rt) << 16) |
			(((int)gt) <<  8) |
			(((int)bt) <<  0);
			mDestination[index] = dpixel;
		}
	}

	//...
	//블러 작업을 직접 수행하거나 작업을 분배하는 compute() 메소드를 구현한다.
	//배열 길이의 임계값은 작업을 수행할 것인지 배열을 분할 할 것인지 결정한다.

	protected static int sThreshold = 100000;

	protected void compute() {
		if (mLength < sThreshold) {
			computeDirectly();
			return;
		}

		int split = mLength / 2;

		invokeAll(new ForkBlur(mSource, mStart, split, mDestination),
				new ForkBlur(mSource, mStart + split, mLength - split,
						mDestination));
	}
}
