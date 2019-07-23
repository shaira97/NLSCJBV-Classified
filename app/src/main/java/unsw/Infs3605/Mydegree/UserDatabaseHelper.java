package unsw.Infs3605.Mydegree;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDatabaseHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 7;
    public static final String DB_NAME="students.db";
    public static final String TABLE_NAME="students";
    public static final String COL_1="ID";
    public static final String COL_2="username";
    public static final String COL_3="password";
    private SQLiteDatabase dbase;

    public UserDatabaseHelper(Context context) {
        super(context, DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS students (ID INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, password TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public long addStudent(String user,String password){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username",user);
        contentValues.put("password",password);
        long res=db.insert("students",null,contentValues);
        db.close();
        return res;

    }

    public boolean checkUsers(String username, String password){

        String[] columns={COL_1};
        SQLiteDatabase db=getReadableDatabase();
        String selection=COL_2 + "=?" + " and " + COL_3 + "=?";
        String[] selectionArgs = {username, password };
        Cursor cursor=db.query(TABLE_NAME,columns,selection,selectionArgs,null,null,null);
        int count=cursor.getCount();
        cursor.close();
        db.close();
        if(count>0)
            return true;
        else
            return false;

    }
}

