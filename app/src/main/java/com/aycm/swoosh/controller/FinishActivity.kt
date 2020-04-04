package com.aycm.swoosh.controller

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aycm.swoosh.R
import com.aycm.swoosh.model.Player
import com.aycm.swoosh.utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)

        searchLeagueTxt.text = "Looking for ${player.league} ${player.skill} league near you..."
    }
}
