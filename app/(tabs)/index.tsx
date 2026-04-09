import { Text, View } from "@/components/Themed";
import React, { useEffect, useState } from "react";
import { ActivityIndicator, FlatList, Image, StyleSheet } from "react-native";

// On définit l'interface pour supprimer les erreurs TypeScript
interface Sae {
  id: number;
  titre: string;
  promo: string;
  domaine: string;
  note: number;
  ue: string;
  image?: string;
}

export default function TabOneScreen() {
  const [saes, setSaes] = useState<Sae[]>([]);
  const [loading, setLoading] = useState(true);

  const loadSaes = async () => {
    try {
      // Utilise bien l'IP de ton Mac ici
      const response = await fetch("http://192.168.1.129:8080/api/saes");
      const data = await response.json();
      setSaes(data);
    } catch (error) {
      console.error("Erreur de récupération:", error);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    loadSaes();
  }, []);

  if (loading) return <ActivityIndicator style={{ flex: 1 }} />;

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Galerie des SAÉ</Text>
      <FlatList
        data={saes}
        keyExtractor={(item) => item.id.toString()}
        renderItem={({ item }) => (
          <View style={styles.card}>
            <Image
              source={{ uri: item.image || "https://via.placeholder.com/150" }}
              style={styles.image}
            />
            <View style={styles.info}>
              <Text style={styles.saeTitle}>{item.titre}</Text>
              <Text>
                {item.domaine} - {item.promo}
              </Text>
              <Text style={styles.note}>Note: {item.note}/20</Text>
              <Text style={styles.ue}>UE: {item.ue}</Text>
            </View>
          </View>
        )}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: { flex: 1, padding: 10 },
  title: {
    fontSize: 24,
    fontWeight: "bold",
    marginVertical: 20,
    textAlign: "center",
  },
  card: {
    flexDirection: "row",
    marginBottom: 15,
    padding: 10,
    borderRadius: 10,
    backgroundColor: "#f0f0f0",
  },
  image: { width: 80, height: 80, borderRadius: 8 },
  info: { marginLeft: 15, justifyContent: "center", flex: 1 },
  saeTitle: { fontSize: 18, fontWeight: "bold" },
  note: { fontWeight: "bold", color: "#2e78b7" },
  ue: { fontSize: 12, color: "#666" },
});
