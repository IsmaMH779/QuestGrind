package com.example.questgrind.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.questgrind.attributes.Player;
import com.example.questgrind.attributes.PlayerRepository;
import com.example.questgrind.dailyQuest.Quest;
import com.example.questgrind.inventory.Item;
import com.example.questgrind.inventory.ItemsRepository;

import java.util.ArrayList;
import java.util.List;

public class AppViewModel extends AndroidViewModel {

    private PlayerRepository playerRepository;
    private MutableLiveData<List<Quest>> questList = new MutableLiveData<>();
    private MutableLiveData<Boolean> allQuestsCompleted = new MutableLiveData<>(false);
    private LiveData<Player> player = new MutableLiveData<>();
    private MutableLiveData<Integer> aviableSkillPoints = new MutableLiveData<>(0);
    private Boolean givedPoints;
    private Boolean givedXp;
    private MutableLiveData<List<Item>> items = new MutableLiveData<>();

    // Constructor
    public AppViewModel(@NonNull Application application) {
        super(application);

        playerRepository = new PlayerRepository(application);

        List<Quest> initialQuest = new ArrayList<>();

        initialQuest.add(new Quest(1, "Flexiones", "[10]",false));
        initialQuest.add(new Quest(2, "Abdominales", "[10]",false));
        initialQuest.add(new Quest(3, "Sentadillas", "[10]",false));
        initialQuest.add(new Quest(4, "Leer", "[10 pag]",false));
        initialQuest.add(new Quest(5, "Estudiar", "[20 min]",false));

        questList.setValue(initialQuest);

        Player p = new Player();

        player = playerRepository.getPlayer();

        aviableSkillPoints.setValue(p.getAviableSkillPoints());
        givedPoints = false;
        givedXp = false;

        ItemsRepository itemsRepository = new ItemsRepository();
        items.setValue(itemsRepository.getItemsRepositoryList());
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

    public LiveData<Player> getPlayer() {
        return player;
    }
    public void updatePlayer(Player player) {
        playerRepository.update(player);
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
            updatePlayer(playerUpdate);
        }

    }

    public void giveXP() {
        if (!givedXp) {
            if (player.getValue() != null) {
                Player updatedPlayer = player.getValue();

                updatedPlayer.giveXP(50);
                updatePlayer(updatedPlayer);
            }
            givedXp = true;
        }

    }

    public MutableLiveData<List<Item>> getItems() {
        return items;
    }
}