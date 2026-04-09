import { Text } from "@/components/Themed";
import React, { useState } from "react";
import {
  Alert,
  ScrollView,
  StyleSheet,
  TextInput,
  TouchableOpacity
} from "react-native";

export default function TabTwoScreen() {
  const [form, setForm] = useState({
    titre: "",
    promo: "MMI2",
    domaine: "",
    note: "",
    ue: "",
  });

  const handleSave = async () => {
    if (!form.titre || !form.note) {
      Alert.alert("Erreur", "Le titre et la note sont obligatoires");
      return;
    }

    try {
      const response = await fetch("http://192.168.1.129:8080/api/saes", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          ...form,
          note: parseFloat(form.note),
        }),
      });

      if (response.ok) {
        Alert.alert("Succès", "SAÉ enregistrée !");
        setForm({ titre: "", promo: "MMI2", domaine: "", note: "", ue: "" });
      }
    } catch (error) {
      Alert.alert("Erreur", "Impossible de contacter le serveur");
    }
  };

  return (
    <ScrollView style={styles.container}>
      <Text style={styles.title}>Ajouter une SAÉ</Text>

      <Text style={styles.label}>Titre</Text>
      <TextInput
        style={styles.input}
        value={form.titre}
        onChangeText={(t) => setForm({ ...form, titre: t })}
      />

      <Text style={styles.label}>Note /20</Text>
      <TextInput
        style={styles.input}
        value={form.note}
        keyboardType="numeric"
        onChangeText={(t) => setForm({ ...form, note: t })}
      />

      <Text style={styles.label}>Domaine</Text>
      <TextInput
        style={styles.input}
        value={form.domaine}
        onChangeText={(t) => setForm({ ...form, domaine: t })}
      />

      <TouchableOpacity style={styles.btn} onPress={handleSave}>
        <Text style={styles.btnText}>Enregistrer</Text>
      </TouchableOpacity>
    </ScrollView>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, padding: 20 },
  title: { fontSize: 22, fontWeight: "bold", marginBottom: 20 },
  label: { marginTop: 15, fontWeight: "bold" },
  input: {
    borderBottomWidth: 1,
    borderColor: "#ccc",
    padding: 10,
    marginBottom: 10,
  },
  btn: {
    backgroundColor: "#2e78b7",
    padding: 15,
    borderRadius: 8,
    marginTop: 20,
  },
  btnText: { color: "#white", textAlign: "center", fontWeight: "bold" },
});
