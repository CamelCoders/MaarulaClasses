package admin.maarula.admin.maarula.Interface;

import android.widget.ImageView;

import admin.maarula.admin.maarula.Models.Courses;

public interface CoursesItemClickListener {
    void onCourseClick(Courses courses, ImageView imageView); // we will need the imageview to make the shared animation between the two activity
}
