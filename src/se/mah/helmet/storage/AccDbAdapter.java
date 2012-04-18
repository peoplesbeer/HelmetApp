package se.mah.helmet.storage;

import android.content.Context;

/**
 * Preliminary database adapter for storing accelerometer data in a SQLite
 * database.
 */
public class AccDbAdapter extends DbAdapter {
	private static final String TAG = AccDbAdapter.class.getSimpleName();

	// Remember to increment versionnumber in DbAdapter when you make changes
	public static final String TABLE_ACC = "acc";
	public static final String KEY_ROWID = "_id";
	public static final String KEY_TIME = "time";
	public static final String KEY_ACCX = "acc_x";
	public static final String KEY_ACCY = "acc_y";
	public static final String KEY_ACCZ = "acc_z";
	public static final String TABLE_ACC_CREATE = 
			"CREATE TABLE " + TABLE_ACC	+ "(" 
			+ KEY_ROWID + " integer primary key autoincrement, "
			+ KEY_TIME + " text not null," 
			+ KEY_ACCX + " real," 
			+ KEY_ACCY + " real," 
			+ KEY_ACCZ + " real"
			+ ")";

	/**
	 * Constructor - takes the context to allow the database to be
	 * opened/created
	 * 
	 * @param ctx
	 *            the Context within which to work
	 */
	public AccDbAdapter(Context context) {
		super(context);
	}

	/**
	 * Old insertion method, less effective.
	 * Insert accelerometer data to database.
	 * 
	 * @param time
	 * @param accX
	 * @param accY
	 * @param accZ
	 * @return the row ID of the newly inserted row, or -1 if an error occurred
	 *         (see android.database.sqlite.SQLiteDatabase.insert(...))
	 *
	public long insertData(String time, double accX, double accY,
			double accZ) {
		ContentValues values = new ContentValues(4);
		values.put(KEY_TIME, time);
		values.put(KEY_ACCX, accX);
		values.put(KEY_ACCY, accY);
		values.put(KEY_ACCZ, accZ);

		return mDb.insert(TABLE_ACC, null, values);
	}
	*/
	
	/**
	 * Insert accelerometer data to database.
	 * 
	 * @param time
	 * @param accX
	 * @param accY
	 * @param accZ
	 */
	public void insertData(String time, double accX, double accY, double accZ) {
		getDb().execSQL(
			"INSERT INTO " + TABLE_ACC +
			" (" + KEY_TIME + "," + KEY_ACCX + "," + KEY_ACCY + "," + KEY_ACCX + ")" +
			" VALUES " +
			" (\"" + time + "\"," + accX + "," + accY + "," + accZ + ");");
	}
}
