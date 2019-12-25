package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes.opengl

import android.content.Context
import android.opengl.GLES20
import android.opengl.GLSurfaceView
import android.opengl.Matrix
import android.os.SystemClock
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

class SplashScreenGLRenderer(val context: Context) : GLSurfaceView.Renderer {

    private lateinit var square: Square
    private val viewMatrix = FloatArray(16)
    private val mvpMatrix = FloatArray(16)
    private val projectionMatrix = FloatArray(16)
    private val rotationMatrix = FloatArray(16)
    private var tempMatrix = FloatArray(16)
    private val modelMatrix = FloatArray(16)
    private var dx = 0f

    override fun onSurfaceCreated(unused: GL10, config: EGLConfig) {
        GLES20.glClearColor(211.0f, 47.0f, 47.0f, 1.0f)

        val squareCoords = floatArrayOf(
            0f, 0.5f, 0.0f,      // top left
            -0.5f, 0f, 0.0f,     // bottom left
            0f, -0.5f, 0.0f,     // bottom right
            0.5f, 0f, 0.0f       // top right
        )
        val color = floatArrayOf(0.768627451f, 0.768627451f, 0.768627451f, 1.0f)

        square = Square(squareCoords, color)
    }

    override fun onDrawFrame(unused: GL10) {
        // Redraw background color
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT)

        rotateSquare(square, 1)
//        rotateSquare(mSquare2, -1)
    }

    override fun onSurfaceChanged(unused: GL10, width: Int, height: Int) {
        GLES20.glViewport(0, 0, width, height)
        val ratio = width.toFloat() / height

        // this projection matrix is applied to object coordinates
        // in the onDrawFrame() method
        Matrix.frustumM(projectionMatrix, 0, -ratio, ratio, -1f, 1f, 3f, 7f)
    }

    private fun rotateSquare(square: Square, direction: Int) {
        Matrix.setIdentityM(modelMatrix, 0) // initialize to identity matrix
        Matrix.translateM(modelMatrix, 0, direction * dx, 0f, 0f) // translation to the left

        // Set the camera position (View matrix)
        Matrix.setLookAtM(viewMatrix, 0, 0f, 0f, -3f, 0f, 0f, 0f, 0f, 1.0f, 0.0f)

        // Calculate the projection and view transformation
        Matrix.multiplyMM(mvpMatrix, 0, projectionMatrix, 0, viewMatrix, 0)

        // Create a rotation transformation for the square
        val time = SystemClock.uptimeMillis() % 4000L
        val angle = direction * 0.090f * time.toInt()
        Matrix.setRotateM(rotationMatrix, 0, angle, 0f, 0f, -1.0f)

        tempMatrix = modelMatrix.clone()
        Matrix.multiplyMM(modelMatrix, 0, tempMatrix, 0, rotationMatrix, 0)
        tempMatrix = mvpMatrix.clone()
        Matrix.multiplyMM(mvpMatrix, 0, tempMatrix, 0, modelMatrix, 0)
        square.draw(mvpMatrix)

    }

}