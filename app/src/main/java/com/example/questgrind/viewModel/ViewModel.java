package com.example.questgrind.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.questgrind.attributes.Player;
import com.example.questgrind.dailyQuest.Quest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ViewModel extends AndroidViewModel {

    // quest
    private MutableLiveData<List<Quest>> questList = new MutableLiveData<>();
    private MutableLiveData<Boolean> allQuestsCompleted = new MutableLiveData<>(false);
    private MutableLiveData<Player> player = new MutableLiveData<>();
    private MutableLiveData<Integer> aviableSkillPoints = new MutableLiveData<>(0);

    // Constructor
    public ViewModel(@NonNull Application application) {
        super(application);

        List<Quest> initialQuest = new ArrayList<>();

        initialQuest.add(new Quest(1, "Flexiones", false));
        initialQuest.add(new Quest(2, "Abdominales", false));
        initialQuest.add(new Quest(3, "Sentadillas", false));
        initialQuest.add(new Quest(4, "Leer", false));
        initialQuest.add(new Quest(5, "Estudiar", false));

        questList.setValue(initialQuest);

        Player p = new Player("Isma", 1);
        player.setValue(p);

        aviableSkillPoints.setValue(p.getAviableSkillPoints());
    }

    /*
    Todo lo que tiene que ver con el questFragment
    */
    public LiveData<List<Quest>> getQuestList() {
        return questList;
    }

    public void updateQuest(int questID, boolean isCompleted) {
        if (questList.getValue() != null) {
            List<Quest> updatedList = new ArrayList<>(questList.getValue());

            for (Quest quest : updatedList) {
                if (quest.getId() == questID) {
                    quest.setCompleted(isCompleted);
                }
            }

            questList.setValue(updatedList);
        }
        // comprobar que todas estan completadas
        checkIfAllQuestsCompleted();
    }

    public MutableLiveData<Boolean> getAllQuestsCompleted() {
        return allQuestsCompleted;
    }

    public void checkIfAllQuestsCompleted() {
        boolean allCompleted = true;
        if (questList.getValue() != null) {
            for (Quest quest : questList.getValue()) {
                if (!quest.getCompleted()) {
                    allCompleted = false;
                    break;
                }
            }
        }

        allQuestsCompleted.setValue(allCompleted);
    }


    /*
    Todo lo que tiene que ver con AttributesFragment
    */

    public MutableLiveData<Integer> getAviableSkillPoints() {
        return aviableSkillPoints;
    }

    public MutableLiveData<Player> getPlayer() {
        return player;
    }

    public void addLevelToAttribute(int attributePos) {
        if (player.getValue() != null) {

            Player playerUpdate = player.getValue();
            switch (attributePos) {
                case 0:
                    playerUpdate.setVitality(playerUpdate.getVitality() + 1);
                    break;
                case 1:
                    playerUpdate.setStrength(playerUpdate.getStrength() + 1);
                    break;
                case 2:
                    playerUpdate.setIntelligence(playerUpdate.getIntelligence() + 1);
                    break;
                case 3:
                    playerUpdate.setAgility(playerUpdate.getAgility() + 1);
                    break;
                case 4:
                    playerUpdate.setPerception(playerUpdate.getPerception() + 1);
                    break;
            }
            playerUpdate.setAviableSkillPoints(playerUpdate.getAviableSkillPoints() - 1);
            player.setValue(playerUpdate);
        }

    }

    public void givePoints() {
        Player playerUpdated = player.getValue();

        playerUpdated.setAviableSkillPoints(playerUpdated.getAviableSkillPoints() + 3);

        player.setValue(playerUpdated);

        aviableSkillPoints.setValue(player.getValue().getAviableSkillPoints());
    }
}
