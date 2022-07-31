package com.appinion.interactive_video

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.view.animation.TranslateAnimation
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.appinion.interactive_video.databinding.ActivityMainBinding
import com.appinion.interactive_video.databinding.QuestionOneBinding
import com.appinion.interactive_video.databinding.QuestionThreeBinding
import com.appinion.interactive_video.databinding.QuestionTowBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import java.util.zip.GZIPOutputStream


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var exoPlayer: ExoPlayer
    private var countDownTimer: CountDownTimer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        exoPlayer = ExoPlayer.Builder(this).build()

        binding.exoPlayer.player = exoPlayer
        val mediaItem: MediaItem =
            MediaItem.fromUri("https://rnd.appinionbd.com/interactive-videos/customer-experience-v02.mp4")
        exoPlayer.addMediaItem(mediaItem)
        exoPlayer.prepare()
        exoPlayer.playWhenReady = true
        var durationSet = false

        var videoWatchedTime: Long = 0

        setTimer()



        questionSelection(binding.lytQuestion)
        questionSelection(binding.lytQuestionTwo)
        questionSelection(binding.lytQuestionThree)
    }

    private fun questionSelection(lytQuestion: QuestionOneBinding) {
        lytQuestion.textView2.setOnClickListener {

            unSelectedAllQuestion(lytQuestion)
            lytQuestion.textView2.background =
                resources.getDrawable(R.drawable.corder_shape_selected)
        }

        lytQuestion.textView3.setOnClickListener {
            unSelectedAllQuestion(lytQuestion)

            lytQuestion.textView3.background =
                resources.getDrawable(R.drawable.corder_shape_selected)

        }

        lytQuestion.textView5.setOnClickListener {
            unSelectedAllQuestion(lytQuestion)
            lytQuestion.textView5.background =
                resources.getDrawable(R.drawable.corder_shape_selected)

        }

        lytQuestion.textView7.setOnClickListener {
            unSelectedAllQuestion(lytQuestion)

            lytQuestion.textView7.background =
                resources.getDrawable(R.drawable.corder_shape_selected)

        }
    }

    private fun questionSelection(lytQuestion: QuestionTowBinding) {
        lytQuestion.textView2.setOnClickListener {

            unSelectedAllQuestion(lytQuestion)
            lytQuestion.textView2.background =
                resources.getDrawable(R.drawable.corder_shape_selected)
        }

        lytQuestion.textView3.setOnClickListener {
            unSelectedAllQuestion(lytQuestion)

            lytQuestion.textView3.background =
                resources.getDrawable(R.drawable.corder_shape_selected)

        }

        lytQuestion.textView5.setOnClickListener {
            unSelectedAllQuestion(lytQuestion)

            lytQuestion.textView5.background =
                resources.getDrawable(R.drawable.corder_shape_selected)

        }

        lytQuestion.textView7.setOnClickListener {
            unSelectedAllQuestion(lytQuestion)

            lytQuestion.textView7.background =
                resources.getDrawable(R.drawable.corder_shape_selected)

        }
    }

    private fun questionSelection(lytQuestion: QuestionThreeBinding) {
        lytQuestion.textView2.setOnClickListener {

            unSelectedAllQuestion(lytQuestion)
            lytQuestion.textView2.background =
                resources.getDrawable(R.drawable.corder_shape_selected)
        }

        lytQuestion.textView3.setOnClickListener {
            unSelectedAllQuestion(lytQuestion)

            lytQuestion.textView3.background =
                resources.getDrawable(R.drawable.corder_shape_selected)

        }

        lytQuestion.textView5.setOnClickListener {
            unSelectedAllQuestion(lytQuestion)

            lytQuestion.textView5.background =
                resources.getDrawable(R.drawable.corder_shape_selected)

        }

        lytQuestion.textView7.setOnClickListener {
            unSelectedAllQuestion(lytQuestion)

            lytQuestion.textView7.background =
                resources.getDrawable(R.drawable.corder_shape_selected)

        }
    }


    private fun unSelectedAllQuestion(binding: QuestionOneBinding) {
        binding.textView3.background = resources.getDrawable(R.drawable.corner_shape)
        binding.textView2.background = resources.getDrawable(R.drawable.corner_shape)
        binding.textView5.background = resources.getDrawable(R.drawable.corner_shape)
        binding.textView7.background = resources.getDrawable(R.drawable.corner_shape)
    }

    private fun unSelectedAllQuestion(binding: QuestionTowBinding) {
        binding.textView3.background = resources.getDrawable(R.drawable.corner_shape)
        binding.textView2.background = resources.getDrawable(R.drawable.corner_shape)
        binding.textView5.background = resources.getDrawable(R.drawable.corner_shape)
        binding.textView7.background = resources.getDrawable(R.drawable.corner_shape)
    }

    private fun unSelectedAllQuestion(binding: QuestionThreeBinding) {
        binding.textView3.background = resources.getDrawable(R.drawable.corner_shape)
        binding.textView2.background = resources.getDrawable(R.drawable.corner_shape)
        binding.textView5.background = resources.getDrawable(R.drawable.corner_shape)
        binding.textView7.background = resources.getDrawable(R.drawable.corner_shape)
    }

    @SuppressLint("DefaultLocale")
    private fun setTimer() {
        var videoWatchedTime: Long = 0

        object : CountDownTimer(30 * 60000, 1000) {
            // adjust the milli seconds here
            var time: Long = 1000
            override fun onTick(millisUntilFinished: Long) {
                videoWatchedTime = exoPlayer.currentPosition / 1000
                time += 1000
                if (videoWatchedTime in 52L..78L) {
                    binding.lytQuestion.lytQuestionOne.visibility = View.VISIBLE
                    if (videoWatchedTime in 68L..78L) {
                        if (!binding.lytQuestion.tvCount.isVisible) {
                            binding.lytQuestion.tvCount.visibility = View.VISIBLE
                            setCounter(binding.lytQuestion.tvCount)
                        }
                    } else if (binding.lytQuestion.tvCount.isVisible && (videoWatchedTime <= 67L || videoWatchedTime >= 79L)) {
                        if (countDownTimer != null) {
                            countDownTimer!!.cancel()
                            binding.lytQuestion.tvCount.visibility = View.GONE

                        }
                    }
                    // slideUp(binding.lytQuestion.lytQuestionOne)
                } else {
                    binding.lytQuestion.lytQuestionOne.visibility = View.GONE
                }

                if (videoWatchedTime in 106L..137L) {
                    if (videoWatchedTime in 127L..137L) {
                        if (!binding.lytQuestionTwo.tvCount.isVisible) {
                            binding.lytQuestionTwo.tvCount.visibility = View.VISIBLE
                            setCounter(binding.lytQuestionTwo.tvCount)
                        }
                    } else if (binding.lytQuestionTwo.tvCount.isVisible && (videoWatchedTime <=126L || videoWatchedTime >= 138L)) {
                        if (countDownTimer != null) {
                            countDownTimer!!.cancel()
                            binding.lytQuestionTwo.tvCount.visibility = View.GONE

                        }
                    }
                    binding.lytQuestionTwo.lytQuestionTwo.visibility = View.VISIBLE
                } else {
                    binding.lytQuestionTwo.lytQuestionTwo.visibility = View.GONE
                }


                if (videoWatchedTime in 199L..239L) {
                    if (videoWatchedTime in 227L..237L) {
                        if (!binding.lytQuestionThree.tvCount.isVisible) {https://www.facebook.com/friends/requests/?profile_id=100081912281497
                            binding.lytQuestionThree.tvCount.visibility = View.VISIBLE
                            setCounter(binding.lytQuestionThree.tvCount)
                        }
                    } else if (binding.lytQuestionThree.tvCount.isVisible && (videoWatchedTime <= 226L || videoWatchedTime >= 238L)) {
                        if (countDownTimer != null) {
                            countDownTimer!!.cancel()
                            binding.lytQuestionThree.tvCount.visibility = View.GONE

                        }
                    }
                    binding.lytQuestionThree.lytQuestionThree.visibility = View.VISIBLE
                } else {
                    binding.lytQuestionThree.lytQuestionThree.visibility = View.GONE
                }
                Log.e("time", videoWatchedTime.toString())
            }

            override fun onFinish() {

            }
        }.start()
    }

    @SuppressLint("DefaultLocale")
    private fun setCounter(view: TextView) {
        var videoWatchedTime: Long = 0
        //  view.visibility = View.VISIBLE
        countDownTimer = object : CountDownTimer(30 * 60000, 1000) {
            // adjust the milli seconds here
            var time: Long = 0
            override fun onTick(millisUntilFinished: Long) {
                time += 1
                view.text = time.toString()
                if (time == 11L) {
                    view.visibility = View.GONE
                    countDownTimer!!.onFinish()
                }
            }

            override fun onFinish() {
                countDownTimer!!.cancel()
            }
        }.start()
    }


    override fun onStop() {
        super.onStop()
        exoPlayer.stop()
    }

}