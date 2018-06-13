package com.example.william.sxcattendance.DataBase;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by william on 3/21/18.
 */

public final class DbContract {

    public static final String CONTENT_AUTHORITY = "com.example.william.sxcattendance.studentprovider";
    public static final String SCHOOL_PATH = "school";
    public static final String ClASS_PATH = "class";
    public static final String SCHEDULE_PATH = "schedules";
    public static final String STUDENT_PATH = "students";
    public static final String DELIVERY_PATH = "delivery";
    public static final String DEPARTMENT_PATH = "department";
    public static final String SEMESTER_PATH = "semester";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://"+CONTENT_AUTHORITY);


    /******Department Table ************/
    public static final class DepartmentEntry implements BaseColumns{

        public static final Uri DEPARTMENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI,DEPARTMENT_PATH);

        public static final String TABLE_NAME = "department";
        public static final String id = BaseColumns._ID;
        public static final String NAME_OF_DEPARTMENT = "name_of_department";
        public static final String HOD =  "hod";
        public static final String CODE = "code";

      /*  public static final String SQL_CREATE_TABLE = "Create table department (\n" +
                "\t_id integer primay key,\n" +
                "\tname_of_department Text\t\n" +
                "\t hod Text"+
                ")\n";*/

        public static final String SQL_CREATE_TABLE = "create table department ( \n" +
                "\t\t_id integer primary key,\n" +
                "\t\tname_of_department text,\n" +
                "\t\tcode integer,\n"+
                "\t\thod text )";


    }

    /******* Semester Data Table ******/
    public static final class SemesterEntry implements BaseColumns {

        public static final Uri SEMESTER_URI = Uri.withAppendedPath(BASE_CONTENT_URI, SEMESTER_PATH);

        public static final String TABLE_NAME = "semester";
        public static final String id = BaseColumns._ID;
        public static final String CODE = "code";
        public static final String VALUE = "value";
        public static final String DEPARTMENT = "department";
        public static final String BATCH = "batch";

        public static final String SQL_CREATE_TABLE = "\n" +
                "create table semester (\n" +
                "\t\t_id integer primary key,\n" +
                "\t\tcode integer,\n" +
                "\t\tvalue text,\n" +
                "\t\tdepartment text,\n" +
                "\t\tbatch integer,\n" +
                "\t\tFOREIGN KEY (department) REFERENCES department ( name_of_department ) )";


    }



   /******** School Data Table   ********/
    public static  final class SchoolEntry implements BaseColumns{

        public static final Uri SCHOOL_URI = Uri.withAppendedPath(BASE_CONTENT_URI, SCHOOL_PATH);

        public static final String TABLE_NAME = "school";

        public static final String id = BaseColumns._ID;
        public static final String SCHOOL_NAME = "schoolName";

        public static final String  SQL_CREATE_TABLE = "Create table School (\n" +
                "\t_id integer primay key,\n" +
                "\tschoolName Text\t\n" +
                ")\n";


    }

    /********  Class Data Table    ********/
    public static final class ClassEntry implements BaseColumns{

        public static final Uri CLASS_URI = Uri.withAppendedPath(BASE_CONTENT_URI,ClASS_PATH);

        public static final String TABLE_NAME = "class";
        public static final String id = BaseColumns._ID;

        public static final String SCHOOL_ID = "schoolId";
        public static final String ClASS_NAME = "className";

        public static final String SQL_CREATE_TABLE = "\n" +
                "create table class (\n" +
                "\t_id integer primary key,\n" +
                "\tschoolId integer,\n" +
                "\tclassName TEXT\n" +
                ")";
    }

    /******** Teacher Details Table     ********/
    public static final class TeachersEntry implements BaseColumns{

        public static final String TABLE_NAME = "teachers";

        public static final String id = BaseColumns._ID;
        public static final String NAME = "name";
        public static final String EMAIL = "email";
        public static final String PHOTO_URL = "photo_url";

        public static final String SQL_CREATE_TABLE = "create table teachers (\n" +
                "\t_id integer primary key,\n" +
                "\tname TEXT,\n" +
                "\temail TEXT,\n" +
                "\taccessToken TEXT,\n"+
                "\tphoto_url TEXT\n" +
                ")\n" +
                "\n";

    }


    /********  Teachers Schedules Table  ********/
    public static final class ScheduleEntry implements BaseColumns{

        public static final Uri SCHEDULE_URI = Uri.withAppendedPath(BASE_CONTENT_URI,SCHEDULE_PATH);

        public static final String TABLE_NAME = "schedules";

        public static final String id = BaseColumns._ID;
        public static final String SCHOOL_ID = "schoolId";
        public static final String CLASS_ID = "classId";
        public static final String TEACHER_ID = "teacher_id";
        public static final String CONTENT = "content";
        public static final String START_DATE = "start_date";
        public static final String END_DATE = "end_date";
        public static final String SCHOOL_NAME = "school_name";
        public static final String CLASS_NAME = "class_name";
        public static final String DELIVER_DATE = "delivery_date";
        public static final String CANCELLED = "cancelled";
        public static final String VACATION = "vacation";
        public static final String DAYS = "days";
        public static final String POSITIONS = "position";


        public static final String SQL_CREATE_TABLE = "CREATE TABLE schedules (\n" +
                "\t_id integer primary key,\n" +
                "\tschoolId INTEGER ,\n" +
                "\tclassId INTEGER ,\n" +
                "\tteacher_id INTEGER ,\n" +
                "\tcontent INTEGER ,\n" +
                "\tstart_date TEXT ,\n" +
                "\tend_date TEXT ,\n" +
                "\tschool_name TEXT ,\n"+
                "\tclass_name TEXT ,\n"+
                "\tdelivery_date TEXT ,\n" +
                "\tdays TEXT ,\n" +
                "\tcancelled TEXT ,\n" +
                "\tvacation TEXT ,\n" +
                "\tposition TEXT ,\n" +
                "\tFOREIGN KEY (schoolId) REFERENCES schedules ( id ),\n" +
                "\tFOREIGN KEY (classId) REFERENCES class ( id )\n" +
                ")";


    }

    /******Student data table ********/
    public static final class StudentsEntry implements BaseColumns{

        public static final Uri STUDENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, STUDENT_PATH);


        public static final String TABLE_NAME = "students";

        public static final String id = BaseColumns._ID;
        public static final String STUDENT_FNAME = "first_name";
        public static final String STUDENT_MNAME = "middle_name";
        public static final String STUDENT_LNAME = "last_name";
        public static final String CONTACT = "contact";
        public static final String DEPARTMENT = "department";
        public static final String SEMESTER = "semester";

        public static final String SQL_CREATE_TABLE = "create table students (\n" +
                "\t\t_id integer primary key,\n" +
                "\t\tfirst_name text,\n" +
                "\t\tmiddle_name text,\n" +
                "\t\tlast_name text,\n" +
                "\t\tcontact text,\n" +
                "\t\tdepartment text,\n" +
                "\t\tsemester integer,\n" +
                "\t\tFOREIGN KEY (department) REFERENCES department ( name_of_department),\n" +
                "\t\tFOREIGN KEY (semester) REFERENCES semester ( _id ) )";


    }


    public static final class deliveryEntery implements BaseColumns{
        public static final Uri DELIVERY_URI = Uri.withAppendedPath(BASE_CONTENT_URI,DELIVERY_PATH);

        public static final String TABLE_NAME = "delivery";

        public static final String id = BaseColumns._ID;
        public static final String DELIVERY_TIME = "delivery_time";
        public static final String RATING = "rating";
        public static final String COMMENT = "comment";

        public static final String CREATE_DELIVERY_TABLE = "Create TABLE delivery( \n" +
                "   _id INTEGER PRIMARY KEY,\n" +
                "   delivery_time TEXT,\n" +
                "   rating REAL,\n" +
                "   comment TEXT)";
    }




}
