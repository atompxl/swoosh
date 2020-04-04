package com.aycm.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.aycm.swoosh.model.Player
import com.aycm.swoosh.R
import com.aycm.swoosh.utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var player = Player("","")

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null){
            player = savedInstanceState.getParcelable<Player>(EXTRA_PLAYER)!!
        }
    }

    fun onMenClicked(view: View) {
        womenLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false

        player.league = "men"
    }

    fun onWomenClicked(view: View) {
        menLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false

        player.league = "women"
    }

    fun onCoedClicked(view: View) {
        womenLeagueBtn.isChecked = false
        menLeagueBtn.isChecked = false

        player.league = "co-ed"
    }

    fun leagueNextClicked(view:View) {
        if(player.league != "") {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(skillActivity)
        } else {
            // Toasts Android
            Toast.makeText(this, "Please select a league.",Toast.LENGTH_SHORT).show()
        }

    }
}
