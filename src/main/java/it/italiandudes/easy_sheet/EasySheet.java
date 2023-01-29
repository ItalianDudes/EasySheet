package it.italiandudes.easy_sheet;

import it.italiandudes.easy_sheet.javafx.JFXDefs;
import it.italiandudes.easy_sheet.javafx.scene.SceneStartup;
import it.italiandudes.idl.common.Logger;
import javafx.application.Application;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("unused")
public final class EasySheet extends Application {

    //Attributes
    public static final DocumentBuilder XML_DOCUMENT_BUILDER;
    static {
        try {
            XML_DOCUMENT_BUILDER = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    private static Stage stage = null;

    //Start Method
    @Override
    public void start(Stage stage) {
        EasySheet.stage = stage;
        stage.setTitle(JFXDefs.AppInfo.NAME);
        stage.getIcons().add(JFXDefs.AppInfo.LOGO);
        stage.setScene(SceneStartup.getScene());
        stage.show();
    }

    //Methods
    @NotNull
    public static Stage getStage(){
        return stage;
    }

    //Main Method
    public static void main(String[] args) {
        try {
            if (Logger.init()) {
                Runtime.getRuntime().addShutdownHook(new Thread(Logger::close));
            }
        }catch (IOException e){
            System.err.println("Logger can't be initialized. Exit...");
        }
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> Logger.log(e));
        launch(args);
    }

    //Defs
    public static final class Defs {
        //This Jar Executable Location
        public static final File JAR_EXECUTABLE_PATH = new File(EasySheet.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParentFile();
        public static final int MAJOR_ABILITIES_NUM = 6;
        public static final int MINOR_ABILITIES_NUM = 18;

        public static final class XMLElementNames {
            public static final class Character {
                public static final String CHARACTER = "character";
                public static final String STORY = "story";
                public static final String ALLIES_AND_ORGANIZATIONS = "allies_and_organizations";
                public static final String ALLY_OR_ORGANIZATION = "ally_or_organization";
                public static final class Vitality {
                    public static final String VITALITY = "vitality";
                    public static final String SPEED = "speed";
                    public static final String MAX_HP = "max_hp";
                    public static final String CURRENT_HP = "current_hp";
                    public static final String TOTAL_HIT_DICE_ROLL = "total_hit_dice";
                    public static final String CURRENT_HIT_DICE_ROLL = "current_hit_dice";
                    public static final String SUCCESS_DEATH_SAVING_THROWS = "success_death_saving_throws";
                    public static final String FAIL_DEATH_SAVING_THROWS = "fail_death_saving_throws";
                    public static final class ArmorClass {
                        public static final String ARMOR_CLASS = "armor_class";
                        public static final String NATURAL_AC = "natural_ac";
                        public static final String ARMOR_AC = "armor_ac";
                        public static final String SHIELD_AC = "shield_ac";
                        public static final String TRAITS_AC = "traits_ac";
                    }
                }
                public static final class Stats {
                    public static final String STATS = "stats";
                    public static final String INSPIRATION_BONUS = "inspiration_bonus";
                    public static final String PROFICIENCY_BONUS = "proficiency_bonus";
                    public static final class MajorAbility {
                        public static final String MAJOR_ABILITY = "major_ability";
                        public static final String ID = "id";
                        public static final String VALUE = "value";
                        public static final String SAVING_THROW_PROFICIENCY = "saving_throw_proficiency";
                    }
                    public static final class Abilities {
                        public static final String ABILITIES = "abilities";
                        public static final String ABILITY = "ability";
                        public static final String PROFICIENCY_LEVEL = "proficiency_level";
                        public static final String ID = "id";
                    }
                    public static final String ABILITIES = "abilities";
                }
                public static final class CharacterHeader {
                    public static final String CHARACTER_HEADER = "character_header";
                    public static final String CHARACTER_NAME = "character_name";
                    public static final String CHARACTER_CLASS = "character_class";
                    public static final String LEVEL = "level";
                    public static final String BACKGROUND = "background";
                    public static final String RACE = "race";
                    public static final String PLAYER_NAME = "player_name";
                    public static final String ALIGNMENT = "alignment";
                    public static final String CAMPAIGN = "campaign";
                    public static final String EXP = "exp";
                }
                public static final class CharacterDescription {
                    public static final String CHARACTER_DESCRIPTION = "character_description";
                    public static final String AGE = "age";
                    public static final String HEIGHT = "height";
                    public static final String WEIGHT = "weight";
                    public static final String EYES = "eyes";
                    public static final String SKIN = "skin";
                    public static final String HAIR = "hair";
                    public static final String CHARACTER_IMAGE ="character_image";
                    public static final class Personality {
                        public static final String PERSONALITY = "personality";
                        public static final String TRAIT = "trait";
                    }
                    public static final class Ideals {
                        public static final String IDEALS = "ideals";
                        public static final String IDEAL = "ideal";
                    }
                    public static final class Flaws {
                        public static final String FLAWS = "flaws";
                        public static final String FLAW = "flaw";
                    }
                    public static final class Bonds {
                        public static final String BONDS = "bonds";
                        public static final String BOND = "bond";
                    }
                    public static final class PrivilegesAndTraits {
                        public static final String PRIVILEGES_AND_TRAITS = "privileges_and_traits";
                        public static final String PRIVILEGE_OR_TRAIT = "privilege_or_trait";
                    }
                }
                public static final class Cult {
                    public static final String CULT = "cult";
                    public static final String NAME = "name";
                    public static final String DESCRIPTION = "description";
                    public static final String IMAGE = "image";
                }
            }
            public static final class Inventory {
                public static final String INVENTORY = "inventory";
                public static final class Item {
                    public static final String ITEM = "item";
                }
                public static final class Wallet {
                    public static final String WALLET = "wallet";
                    public static final String COPPER_COINS = "copper_coins";
                    public static final String SILVER_COINS = "silver_coins";
                    public static final String ELECTRUM_COINS = "electrum_coins";
                    public static final String GOLD_COINS = "gold_coins";
                    public static final String PLATINUM_COINS = "platinum_coins";
                }
            }
            public static final class SpellCategory {
                public static final String SPELL_CATEGORY = "spell_category";
                public static final class CasterHeader {
                    public static final String CASTER_HEADER = "caster_header";
                    public static final String CASTER_CLASS = "caster_class";
                    public static final String CASTER_ABILITY = "caster_ability";
                    public static final String CD_SPELL_SAVING_THROWS = "cd_spell_saving_throws";
                    public static final String SPELL_ATTACK_BONUS = "spell_attack_bonus";
                }
                public static final class Spell {
                    public static final String SPELL = "spell";
                    public static final String NAME = "name";
                    public static final String LEVEL = "level";
                    public static final String TYPE = "type";
                    public static final String DESCRIPTION = "description";
                    public static final String IMAGE = "image";
                }
            }
        }

    }

}
