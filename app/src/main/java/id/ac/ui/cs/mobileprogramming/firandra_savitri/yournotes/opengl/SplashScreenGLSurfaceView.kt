package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes.opengl

import android.content.Context
import android.opengl.GLSurfaceView
import android.util.AttributeSet

class SplashScreenGLSurfaceView(context: Context, attrs: AttributeSet) : GLSurfaceView(context, attrs) {

    private val renderer: SplashScreenGLRenderer

    init {

        // Create an OpenGL ES 2.0 context
        setEGLContextClientVersion(2)

        renderer = SplashScreenGLRenderer(context)

        // Set the Renderer for drawing on the GLSurfaceView
        setRenderer(renderer)
    }
}